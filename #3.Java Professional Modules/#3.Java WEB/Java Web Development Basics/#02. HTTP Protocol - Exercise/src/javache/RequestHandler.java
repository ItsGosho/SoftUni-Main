package javache;

import javache.http.http_request.HTTPRequest;
import javache.http.http_request.HTTPRequestImp;
import javache.http.http_response.HTTPResponse;
import javache.http.http_response.HTTPResponseImp;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class RequestHandler {

   public byte[] handleRequest(String request) throws IOException {
       HTTPRequest httpRequest = new HTTPRequestImp(request);
       HTTPResponse httpResponse = new HTTPResponseImp();
       httpResponse.setPath(httpRequest.getRequestURL());
       httpResponse.setStatusCode(200);

       return httpResponse.getBytes();
   }
}
