import java.util.Scanner;

public class T15_ThreeQualNumbers {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer first = Integer.parseInt(scanner.nextLine());
        Integer secound = Integer.parseInt(scanner.nextLine());
        Integer third = Integer.parseInt(scanner.nextLine());

        if (first.equals(secound) && secound.equals(third)) {
            System.out.printf("yes");
        } else {
            System.out.printf("no");
        }
    }
}
