import java.util.Scanner;

public class T04_SumNumbers {
    //Gosho------------------------>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        Long sum = 0L;
        for (int i = 0; i < n; i++) {
            Integer currentNumber = scanner.nextInt();
            sum += currentNumber;
        }
        System.out.println(sum);
    }
}
