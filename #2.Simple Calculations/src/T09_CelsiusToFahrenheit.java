import java.util.Scanner;

public class T09_CelsiusToFahrenheit {
    //Gosho----------------->
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        Double celsium = Double.parseDouble(scanner.nextLine());
        Double fahrenheit = 32 + (celsium * 9 / 5);

        System.out.printf("%.2f", fahrenheit);
    }
}
