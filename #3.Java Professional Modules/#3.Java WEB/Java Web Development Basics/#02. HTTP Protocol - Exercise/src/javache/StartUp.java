package javache;

import javache.io.Writer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class StartUp {
    public static void main(String[] args) throws IOException {
        Server server=new Server();
        server.run();

    }
}
