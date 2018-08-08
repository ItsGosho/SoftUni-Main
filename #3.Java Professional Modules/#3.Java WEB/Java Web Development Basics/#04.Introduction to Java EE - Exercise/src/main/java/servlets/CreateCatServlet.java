package servlets;

import database.models.Cat;
import database.models.FloatingDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@WebServlet("/cats/create")
public class CreateCatServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Create a Cat!</h1>");
        resp.getWriter().println("<form method=\"post\">");
        resp.getWriter().println("Name:<input type=\"text\" name=\"name\"><br>");
        resp.getWriter().println("Breed:<input type=\"text\" name=\"breed\"><br>");
        resp.getWriter().println("Color:<input type=\"text\" name=\"color\"><br>");
        resp.getWriter().println("Number of legs:<input type=\"number\" name=\"numberOfLegs\"><br>");
        resp.getWriter().println("<input type=\"submit\" value=\"Create Cat\">");
        resp.getWriter().println("</form>");
        resp.getWriter().println("<a href=\"/goshoweb/index\">Back To Home</a>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String[] data = buffer.toString().split("&");
        HashMap<String, String> nameValue = new LinkedHashMap<String, String>();
        boolean exception=false;
        for (int i = 0; i < data.length; i++) {
            String[] split = data[i].split("=");
            if(split.length!=2){
                exception=true;
            }else{
                nameValue.put(split[0].toLowerCase(), URLDecoder.decode(split[1]));
            }
        }
        if(!exception){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("name", nameValue.get("name"));
            httpSession.setAttribute("breed", nameValue.get("breed"));
            httpSession.setAttribute("color", nameValue.get("color"));
            httpSession.setAttribute("numberOfLegs", nameValue.get("numberoflegs"));
            resp.addCookie(new Cookie("user", httpSession.getId()));
            Cat cat=new Cat();
            cat.setName(nameValue.get("name"));
            cat.setBreed(nameValue.get("breed"));
            cat.setColor( nameValue.get("color"));
            cat.setNumberOfLegs(Integer.parseInt(nameValue.get("numberoflegs")));
            FloatingDB.getCats().put(nameValue.get("name"),cat);
            resp.sendRedirect("/goshoweb/cats/profile");
        }else{
            resp.sendRedirect("/goshoweb/cats/create");
        }
    }
}
