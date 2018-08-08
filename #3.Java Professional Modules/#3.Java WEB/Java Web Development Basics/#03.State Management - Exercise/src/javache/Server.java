import http.sessions.HttpSessionStorage;

import java.io.*;
import java.net.*;
import java.util.concurrent.FutureTask;

public class Server {
    private static final String TIMEOUT_DETECTION_MESSAGE = "Timeout detected!";
    private static final Integer SOCKET_TIMEOUT_MILLISECONDS = 5000;

    private int port;
    private int timeouts;
    private ServerSocket server;

    public Server(int port) {
        this.port = port;
        this.timeouts = 0;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);
        System.out.println(String.format("Сървърът е пуснат на порт: %d",this.port));

        /*Слагаме на сървъра време от 5 секунди ,като ако не се свърже никой към сървъра за тези
        5 секунди ,програмата ще хвърли Socket Timeout Exception*/
        this.server.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

        //Инициализираме си Storag-а за сесийте ,който ще са валидни докато програмата ни не спре
        HttpSessionStorage serverSessionStorage = new HttpSessionStorage();

        while(true) {

            //CORE: Всеки път ще accept-тваме връзките към нас
            try(Socket clientSocket = this.server.accept()) {
                clientSocket.setSoTimeout(SOCKET_TIMEOUT_MILLISECONDS);

                ConnectionHandler connectionHandler
                        = new ConnectionHandler(clientSocket, new RequestHandler(serverSessionStorage));

                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
                //REQUEST HANDLER ->
                task.run();
            } catch(SocketTimeoutException e) {
                System.out.println(TIMEOUT_DETECTION_MESSAGE);
                this.timeouts++;
            }
        }
    }
}