package itsgosho.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggingService {

    private static DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void info(String content) {
        System.out.println("\u001B[32m"+formatPattern.format(LocalDateTime.now()) + " [INFO] " + content);
    }

    public static void warning(String content) {
        System.out.println("\u001B[33m"+formatPattern.format(LocalDateTime.now()) + "[WARNING] " + content);
    }

    public static void error(String content) {
        System.out.println("\u001B[31m"+formatPattern.format(LocalDateTime.now()) + "[ERROR] " + content);
    }
}
