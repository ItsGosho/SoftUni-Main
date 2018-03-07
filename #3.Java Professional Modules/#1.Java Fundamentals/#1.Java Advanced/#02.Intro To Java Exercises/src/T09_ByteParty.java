import java.util.Arrays;
import java.util.Scanner;

public class T09_ByteParty {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        int n = Integer.parseInt(skener.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(skener.nextLine());
        }
        while (true) {
            String[] line = skener.nextLine().split(" ");
            if (line[0].equals("party")) {
                break;
            }
            int chislo = Integer.parseInt(line[0]);
            int position = Integer.parseInt(line[1]);
            if (chislo == -1) {
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] ^ (1 << position);
                }
            } else if (chislo == 0) {
                int shift = ~(1 << position);
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] & shift;
                }
            } else if (chislo == 1) {
                int shift = (1 << position);
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] | shift;
                }
            }
        }
        for (int item : numbers) {
            System.out.println(item);
        }
    }
}
