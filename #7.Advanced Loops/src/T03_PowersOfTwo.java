import java.util.Scanner;

public class T03_PowersOfTwo {
    //Gosho------------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());
        Integer num = 1;
        for (int i = 0; i <= n; i++) {

            System.out.println(num);
            num *= 2;
        }
    }
}
