import java.util.Scanner;

public class T05_MaxNumbers {
    //Gosho------------------------>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        Integer max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            Integer currentNumber = scanner.nextInt();
            if (currentNumber > max) {
                max = currentNumber;
            }
        }
        System.out.println(max);
    }
}
