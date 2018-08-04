package javache.http.http_request;

import java.util.HashMap;

public interface HTTPRequest {

    HashMap<String,String> getHeaders();
    HashMap<String,String> getBodyParameters();
    String getMethod();
    void setMethod(String method);
    String getRequestURL();
    void setRequestURL(String requestURL);
    void addHeader(String header,String value);
    void addBodyParameter(String parameter,String value);
    boolean isResource();
}
