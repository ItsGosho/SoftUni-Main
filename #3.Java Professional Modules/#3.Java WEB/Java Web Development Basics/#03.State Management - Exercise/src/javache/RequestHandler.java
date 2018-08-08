import db.User;
import http.*;
import http.cookies.HttpCookie;
import http.requests.HttpRequest;
import http.requests.HttpRequestImpl;
import http.responses.HttpResponse;
import http.responses.HttpResponseImpl;
import http.sessions.HttpSession;
import http.sessions.HttpSessionImpl;
import http.sessions.HttpSessionStorage;
import http.status.HttpStatusProcess;
import http.status.HttpStatusProcessImp;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class RequestHandler {
    private static final String HTML_EXTENSION_AND_SEPARATOR = ".html";

    private HttpRequest httpRequest;
    private HttpResponse httpResponse;
    private HttpSessionStorage sessionStorage;
    private HttpStatusProcess httpStatusProcess;

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    public RequestHandler(HttpSessionStorage sessionStorage) throws IOException {
        this.sessionStorage = sessionStorage;
        this.entityManagerFactory=Persistence.createEntityManagerFactory("site");
        System.out.println("Entity Manager Factory Create - Successful");
        this.entityManager = this.entityManagerFactory.createEntityManager();
    }

    public byte[] handleRequest(String requestContent) throws IOException {
        this.httpRequest = new HttpRequestImpl(requestContent);
        this.httpResponse = new HttpResponseImpl();
        this.httpStatusProcess = new HttpStatusProcessImp(this.httpResponse);

        byte[] result = null;

        if(this.httpRequest.getMethod().equals("GET")) {
            result = this.processGetRequest();
        }else if(this.httpRequest.getMethod().equals("POST")){
            result = this.processPostRequest();
        }

        this.sessionStorage.refreshSessions();

        return result;
    }

    private String getMimeType(File file) {
        String fileName = file.getName();

        if(fileName.endsWith("css")) {
            return "text/css";
        } else if (fileName.endsWith("html")) {
            return "text/html";
        } else if (fileName.endsWith("jpg") || fileName.endsWith("jpeg")) {
            return "image/jpeg";
        } else if (fileName.endsWith("png")) {
            return "image/png";
        }

        return "text/plain";
    }

    private byte[] processResourceRequest() {
        String assetPath = WebConstants.ASSETS_FOLDER_PATH +
                this.httpRequest.getRequestUrl();

        File file = new File(assetPath);

        if(!file.exists() || file.isDirectory()) {
            return this.httpStatusProcess.notFound(("Asset not found!").getBytes());
        }

        byte[] result = null;

        try {
            result = Files.readAllBytes(Paths.get(assetPath));
        } catch (IOException e) {
            return this.httpStatusProcess.internalServerError(("Something went wrong!").getBytes());
        }

        this.httpResponse.addHeader("Content-Type", this.getMimeType(file));
        this.httpResponse.addHeader("Content-Length", result.length + "");
        this.httpResponse.addHeader("Content-Disposition", "inline");

        return this.httpStatusProcess.ok(result);
    }

    private byte[] processPageRequest(String page) {
        String pagePath = WebConstants.PAGES_FOLDER_PATH +
                page
                + HTML_EXTENSION_AND_SEPARATOR;

        File file = new File(pagePath);

        if(!file.exists() || file.isDirectory()) {
            return this.httpStatusProcess.notFound(("Page not found!").getBytes());
        }

        byte[] result = null;

        try {
            result = Files.readAllBytes(Paths.get(pagePath));
        } catch (IOException e) {
            return this.httpStatusProcess.internalServerError(("Something went wrong!").getBytes());
        }

        this.httpResponse.addHeader("Content-Type", this.getMimeType(file));

        return this.httpStatusProcess.ok(result);
    }

    private byte[] processGetRequest() throws IOException {
        if(this.httpRequest.getRequestUrl().equals("/")) {
            //INDEX

            return this.processPageRequest("/index");
        } else if (this.httpRequest.getRequestUrl().equals("/login")) {
            //TODO:      --_! LOGIN !_--      TODO\\

            HashMap<String, HttpCookie> cookies = this.httpRequest.getCookies();
            if(cookies.containsKey("user")){
                HttpSession key = this.sessionStorage.getById(cookies.get("user").getValue());
                if(key!=null){
                    String email=URLDecoder.decode(String.valueOf(key.getAttributes().get("email")));
                    String password=URLDecoder.decode(String.valueOf(key.getAttributes().get("password")));
                    List<User> users =  this.entityManager.createQuery("select u from User as u").getResultList();
                    for (User user : users) {
                        if(user.getPassword().equals(password) && user.getEmail().equals(email)){
                            return this.dynamicUserPage(user.getId());
                        }else{
                            return this.processPageRequest(this.httpRequest.getRequestUrl());
                        }
                    }
                }
                return this.processPageRequest(this.httpRequest.getRequestUrl());
            }
            return this.processPageRequest(this.httpRequest.getRequestUrl());
        } else if (this.httpRequest.getRequestUrl().equals("/register")) {
            //REGISTER

            return this.processPageRequest(this.httpRequest.getRequestUrl());
        }else if (this.httpRequest.getRequestUrl().equals("/logout")) {
            //LOGOUT
            if(!this.httpRequest.getCookies().containsKey("user")) {
                return this.httpStatusProcess.redirect(("You must login to access this route!").getBytes()
                        , "/");
            }

            String sessionId = this.httpRequest.getCookies().get("user").getValue();
            this.sessionStorage.getById(sessionId).invalidate();

            this.httpResponse.addCookie("user", "deleted; expires=Thu, 01 Jan 1970 00:00:00 GMT;");

            return this.processPageRequest("/index");
        } else if (this.httpRequest.getRequestUrl().equals("/forbidden")) {
            //FORBIDDEN

            if(!this.httpRequest.getCookies().containsKey("Javache")) {
                return this.httpStatusProcess.redirect(("You must login to access this route!").getBytes()
                        , "/");
            }

            String sessionId = this.httpRequest.getCookies().get("Javache").getValue();
            HttpSession session = this.sessionStorage.getById(sessionId);
            String username = session.getAttributes().get("username").toString();

            return this.httpStatusProcess.ok(("HELLO " + username + "!!!").getBytes());
        }else if(this.httpRequest.getRequestUrl().equals("/users/profile")){

           return this.processPageRequest(this.httpRequest.getRequestUrl());
        }
        return this.processResourceRequest();
    }

    private byte[] processPostRequest() throws IOException {
          if(this.httpRequest.getRequestUrl().equals("/register")){
              HashMap<String,String> bodyParameters = this.httpRequest.getBodyParameters();
              String email= bodyParameters.get("email");
              String password= bodyParameters.get("password");
              String confirmPassword= bodyParameters.get("confirmPassword");

              if(password.equals(confirmPassword)){

                  this.entityManager.getTransaction().begin();
                  User user = new User();
                  user.setEmail(URLDecoder.decode(String.valueOf(email)));
                  user.setPassword(URLDecoder.decode(String.valueOf(password)));
                  this.entityManager.persist(user);
                  this.entityManager.getTransaction().commit();

                  return this.processPageRequest("\\login");
              }else{
                  //they are not equals
                  return this.processPageRequest("\\register");
              }
          }else if(this.httpRequest.getRequestUrl().equals("/login")) {
              HashMap<String, String> bodyParameters = this.httpRequest.getBodyParameters();
              String email = URLDecoder.decode(String.valueOf(bodyParameters.get("email")));
              String password = bodyParameters.get("password");
              List<User> users =  this.entityManager.createQuery("select u from User as u").getResultList();
              for (User user : users) {
                  if(user.getEmail().equals(email) && user.getPassword().equals(password)){

                      HttpSession httpSession = new HttpSessionImpl();
                      httpSession.addAttribute("email",email);
                      httpSession.addAttribute("password",password);
                      this.sessionStorage.addSession(httpSession);
                      this.httpResponse.addCookie("user",httpSession.getId());

                      return dynamicUserPage(user.getId());
                  }else{
                      return this.processPageRequest("\\login");
                  }
              }
          }
          return new byte[0];
    }

    private  byte[] dynamicUserPage(int userId) throws IOException {
        BufferedReader bf=new BufferedReader(new FileReader(new File("src/resources/pages/users/profile.html")));
        StringBuilder str = new StringBuilder();

        while(bf.ready()) {
            str.append((char) bf.read());
        }

        User user = this.entityManager.find(User.class,userId);
        int usernameIndex=str.indexOf("@");
        str.replace(usernameIndex,usernameIndex+1,user.getEmail());
        int passwordIndex=str.indexOf("#");
        str.replace(passwordIndex,passwordIndex+1,user.getPassword());
        byte[] result = str.toString().getBytes();
        return this.httpStatusProcess.ok(result);
    }
}
