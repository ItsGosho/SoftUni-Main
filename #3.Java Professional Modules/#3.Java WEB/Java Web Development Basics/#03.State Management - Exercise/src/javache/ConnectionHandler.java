import io.Reader;
import io.Writer;

import java.io.*;
import java.net.Socket;

public class ConnectionHandler extends Thread {
    private Socket clientSocket;
    private InputStream clientSocketInputStream;
    private OutputStream clientSocketOutputStream;
    private RequestHandler requestHandler;

    public ConnectionHandler(Socket clientSocket, RequestHandler requestHandler) {
        //Приемане на Socket-та и инициализация на Input & Output Stream-a от него
        this.initializeConnection(clientSocket);
        this.requestHandler = requestHandler;
    }

    private void initializeConnection(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            //Input Stream-a ни взима Header-ите ,Body-то и т.н от сокета
            this.clientSocketInputStream = this.clientSocket.getInputStream();
            //С Output Stream-a връщаме към Socket-та
            this.clientSocketOutputStream = this.clientSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            //Приемаме заявката
            String requestContent = Reader.readAllLines(this.clientSocketInputStream);
            //Обработваме заявката
            byte[] responseContent = this.requestHandler.handleRequest(requestContent);
            //Връщаме заявката на Socket Output-та
            Writer.writeBytes(responseContent, this.clientSocketOutputStream);

            this.clientSocketInputStream.close();
            this.clientSocketOutputStream.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






