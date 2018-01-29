import java.util.Scanner;

public class T16_Number0To100ToText {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        String[] array = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] beginning = new String[]{"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety", "one hundred"};
        String[] end = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        if (n >= 0 && n <= 100) {
            if (n < 10 && n >= 0) {
                System.out.printf(end[n]);
            } else if (n < 20 && n >= 0) {
                System.out.printf(array[n - 10]);
            } else if (n >= 20 && n % 10 == 0) {
                int b = n / 10 - 1;
                System.out.printf(beginning[b]);
            } else if (n > 20 && n < 100 && n % 10 != 0) {
                int c = n % 10;
                int d = n / 10 - 1;

                System.out.printf("%s %s", beginning[d], end[c]);
            }
        }
        else {
            System.out.printf("invalid number");
        }
    }
}
