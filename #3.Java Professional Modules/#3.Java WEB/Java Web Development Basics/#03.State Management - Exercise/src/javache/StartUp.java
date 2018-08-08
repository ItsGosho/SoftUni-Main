import db.User;
import http.WebConstants;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class StartUp {
    public static void main(String[] args) throws IOException {
        //Инициалицираме класа ни сървър ,който ще слуша на порт - 80
        Server server = new Server(80);
        //RUN
        server.run();
    }
}
