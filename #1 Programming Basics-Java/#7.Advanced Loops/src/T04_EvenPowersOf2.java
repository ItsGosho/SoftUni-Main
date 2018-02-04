import java.util.Scanner;

public class T04_EvenPowersOf2 {
    //Gosho------------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        Integer num = 1;
        for (int i = 0; i <= n; i +=2) {

            System.out.println(num);
            num *= 4;
        }
    }
}
