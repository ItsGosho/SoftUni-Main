import java.util.Scanner;

public class T02_NumbersEndingIn7 {
    //Gosho------------------------>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        for (int i = 7; i < 1000; i++) {
            if (i % 10 == 7) {
                System.out.println(i);
            }
        }
    }
}
