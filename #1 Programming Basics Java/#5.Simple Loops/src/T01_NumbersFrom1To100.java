import java.util.Scanner;

public class T01_NumbersFrom1To100 {
    //Gosho------------------------>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer zero = scanner.nextInt();

        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }
    }
}
