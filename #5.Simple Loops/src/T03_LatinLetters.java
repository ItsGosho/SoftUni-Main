import java.util.Scanner;

public class T03_LatinLetters {
    //Gosho------------------------>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        for (char i = 'a'; i <= 'z'; i++) {
            System.out.printf(i + " ");
        }
    }
}
