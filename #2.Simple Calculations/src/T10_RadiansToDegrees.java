import java.util.Scanner;

public class T10_RadiansToDegrees {
    //Gosho----------------->
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        Double radians = Double.parseDouble(scanner.nextLine());

        Double degree = radians / (Math.PI / 180.0);

        System.out.println(degree);
    }
}
