import java.util.Scanner;

public class T03_EvenOrOdd {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int first = Integer.parseInt(scanner.nextLine());
        int secound = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        if (n%2==0){
            System.out.println("even");
        }
        else {
            System.out.println("odd");
        }


    }
}
