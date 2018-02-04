import java.util.Scanner;

public class T10_Number100to200 {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer size = Integer.parseInt(scanner.nextLine());

        if (size < 100) {
            System.out.printf("Less than 100");
        } else if (size >= 100 && size <= 200) {
            System.out.printf("Between 100 and 200");
        } else if (size > 200) {
            System.out.printf("Greater than 200");
        }
    }
}
