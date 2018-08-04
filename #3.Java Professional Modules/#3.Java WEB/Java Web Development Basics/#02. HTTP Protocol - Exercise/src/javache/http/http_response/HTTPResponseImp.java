package javache.http.http_response;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.SocketHandler;

public class HTTPResponseImp implements HTTPResponse {

    private int statusCode;
    private String path;

    @Override
    public HashMap<String, String> getHeaders() {
        return null;
    }

    @Override
    public int getStatusCode() {
        return this.statusCode;
    }

    @Override
    public byte[] getContent() {
        return new byte[0];
    }

    @Override
    public byte[] getBytes() throws IOException {

        BufferedReader bufferedReader = null;
        File[] folders =  new File("src/resources/").listFiles();
        for (File folder : folders) {
            File[] papka= folder.listFiles();
            for (File file : papka) {

                int t1=file.getName().lastIndexOf(".");
                String t2=file.getName().substring(0,t1);

                String toCheck="/"+t2;
                if(toCheck.equals(getPath())){
                   bufferedReader = new BufferedReader(new FileReader(file.getPath()));
                    break;
                }
            }
        }
        String test = "";
        while (bufferedReader.ready()){
            test +=(char)bufferedReader.read();
        }
        String res="";
        res+=String.format("HTTP/1.1 %d OK\r\n",getStatusCode());
        res+=String.format("Content-Type: text/html\r\n");
        res+=String.format("\r\n");
        res+=String.format("%s\r\n",test);
        return res.getBytes();
    }

    @Override
    public void setStatusCode(int statusCode) {
        this.statusCode=statusCode;
    }

    @Override
    public void setContent(byte[] content) {

    }

    @Override
    public void addHeader(String header, String value) {

    }

    @Override
    public void setPath(String path) {
          this.path=path;
    }

    @Override
    public String getPath() {
        return this.path;
    }
}
