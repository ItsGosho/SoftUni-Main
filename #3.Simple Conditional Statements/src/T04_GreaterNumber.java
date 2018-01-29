import java.util.Scanner;

public class T04_GreaterNumber {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int secound = Integer.parseInt(scanner.nextLine());


        if (first > secound) {
            System.out.println(first);
        } else {
            System.out.println(secound);
        }
    }
}
