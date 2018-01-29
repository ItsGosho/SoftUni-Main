import java.util.Scanner;

public class T05_InvalidNumber {
    //Gosho--------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        if (n >= 100 && n <= 200 || n == 0){

        }
        else {
            System.out.printf("invalid");
        }
    }
}
