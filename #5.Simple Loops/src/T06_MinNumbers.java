import java.util.Scanner;

public class T06_MinNumbers {
    //Gosho------------------------>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        Integer min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Integer currentNumber = scanner.nextInt();
            if (currentNumber < min) {
                min = currentNumber;
            }
        }
        System.out.println(min);
    }
}
