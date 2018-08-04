package javache;

import javache.io.Reader;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.FutureTask;
public class ConnectionHandler  extends Thread{

    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private RequestHandler requestHandler;
    private BufferedReader reader;

    public ConnectionHandler(Socket socket, RequestHandler requestHandler) {
          this.initializeConnection(socket);
          this.requestHandler=requestHandler;
          this.reader=new BufferedReader(new InputStreamReader(this.inputStream));
    }

    @Override
    public void run() {
        String request = null;
        try {
            request = Reader.readAllLines(this.inputStream);
            byte[] responseContent = this.requestHandler.handleRequest(request);
            try {
                javache.io.Writer.writerBytes(responseContent,this.outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                this.inputStream.close();
                this.outputStream.close();
                this.clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initializeConnection(Socket socket) {
        try {
            this.clientSocket=socket;
            this.inputStream=socket.getInputStream();
            this.outputStream=socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
