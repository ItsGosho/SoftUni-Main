import java.util.Scanner;

public class T11_EqualWords {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine().toLowerCase();
        String secound = scanner.nextLine().toLowerCase();

        if (first.equals(secound)) {
            System.out.printf("yes");
        }
        else {
            System.out.printf("no");
        }
    }
}
