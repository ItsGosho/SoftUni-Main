package javache.http.http_response;

import java.io.IOException;
import java.util.HashMap;

public interface HTTPResponse  {

    HashMap<String,String> getHeaders();
    int getStatusCode();
    byte[] getContent();
    byte[] getBytes() throws IOException;
    void setStatusCode(int statusCode);
    void setContent(byte[] content);
    void addHeader(String header,String value);

    //when you are lazy and you want to finish fast ;d
    void setPath(String path);
    String getPath();
}
