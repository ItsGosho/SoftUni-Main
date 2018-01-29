import java.util.Scanner;

public class T02_ExcellentOrNot {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());

        if (grade >= 5.50 && grade <= 6.00) {
            System.out.printf("Excellent!");
        }
        else if (grade < 5.50 && grade >=2.00){
            System.out.printf("Not excellent.");
        }
    }
}
