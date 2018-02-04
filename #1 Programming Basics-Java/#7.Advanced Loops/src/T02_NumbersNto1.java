import java.util.Scanner;

public class T02_NumbersNto1 {
    //Gosho------------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());


        for (int i = n; i >= 1; i--) {
            System.out.println(i);
        }
    }
}
