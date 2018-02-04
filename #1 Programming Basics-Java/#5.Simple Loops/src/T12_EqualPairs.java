import java.util.Scanner;

public class T12_EqualPairs {
    //Gosho------------------------>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = scanner.nextInt();

        Integer currentSum = 0;
        Integer previousSum = 0;
        Integer diff = 0;
        Integer maxDiff = 0;
        for (int i = 0; i < n; i++) {
            previousSum = currentSum;
            currentSum = 0;
            currentSum += scanner.nextInt();
            currentSum += scanner.nextInt();
            if (i != 0) {
                diff = Math.abs(currentSum - previousSum);
                if (diff != 0 && diff > maxDiff) {
                    maxDiff = diff;
                }
            }
        }
        if (previousSum == currentSum || n == 1) {
            System.out.printf("Yes, value=%d", currentSum);

        } else {
            System.out.printf("No, maxdiff=%d", maxDiff);
        }
    }
}
