import java.util.Scanner;

public class T01_ExcellentResult {
    //Gosho----------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 5.50 && grade <= 6.00) {
            System.out.printf("Excellent!");
        }
    }
}
