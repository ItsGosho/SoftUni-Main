package javache;

import java.io.IOException;
import java.net.*;
import java.util.concurrent.FutureTask;

public class Server extends Thread{

    private ServerSocket serverSocket;

    public Server() throws IOException {
        this.serverSocket=new ServerSocket(80);
        this.serverSocket.setReuseAddress(true);
        this.serverSocket.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILITSECONDS );
    }

    @Override
    public void run() {
        double counter=0.00;
        int seconds=0;
        int minutes=0;
        int hours=0;
        while (true){
            try(Socket socket = this.serverSocket.accept()){
                socket.setSoTimeout(WebConstants.SOCKET_TIMEOUT_MILITSECONDS);

                ConnectionHandler connectionHandler
                        = new ConnectionHandler(socket,new RequestHandler());
                FutureTask<?> task = new FutureTask<>(connectionHandler,null);
                task.run();
                counter+=0.5;
            } catch (IOException e) {
                System.out.println(String.format("Total times connected %.0f Total time without shutdown %dh %dm %ds",counter,hours,minutes,seconds));
            }
            seconds++;
            if(seconds==60){
                seconds-=60;
                minutes++;
            }
            if(minutes==60){
                minutes-=60;
                hours++;
            }
        }
    }
}
