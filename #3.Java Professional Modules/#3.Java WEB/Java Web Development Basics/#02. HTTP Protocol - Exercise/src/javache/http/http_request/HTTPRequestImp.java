package javache.http.http_request;

import java.util.*;

public class HTTPRequestImp implements HTTPRequest {

    private List<String> requestList;

    public HTTPRequestImp(String request) {
        this.requestList = Arrays.asList(request.split("\r\n"));
    }

    @Override
    public HashMap<String, String> getHeaders() {
        HashMap<String,String> toReturn = new LinkedHashMap<>();
        for (int i = 1; i < requestList.size(); i++) {
               String[] splitted = requestList.get(i).split(":");
               toReturn.put(splitted[0],requestList.get(i));
        }
        return toReturn;
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        return null;
    }

    @Override
    public String getMethod() {
        String[] reqMethod=this.requestList.get(0).split(" ");
        return reqMethod[0];
    }

    @Override
    public void setMethod(String method) {

    }

    @Override
    public String getRequestURL() {
        String[] reqURL=this.requestList.get(0).split(" ");
        return reqURL[1];
    }

    @Override
    public void setRequestURL(String requestURL) {

    }

    @Override
    public void addHeader(String header, String value) {

    }

    @Override
    public void addBodyParameter(String parameter, String value) {

    }

    @Override
    public boolean isResource() {
        return false;
    }
}
