import java.util.Scanner;

public class T02_InchesToCentimeters {
    //Gosho----------------->
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        System.out.print("inches: ");
        Double inches = Double.parseDouble(scanner.nextLine());
        Double centimeters = inches * 2.54;
        System.out.println("centimeters = " + centimeters);
    }
}
