import java.util.Scanner;

public class T05_Number0To9ToText {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        String[] myIntArray = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "number too big"};

        if (n >= 0 && n < 10){
            System.out.println(myIntArray[n]);
        }
        else System.out.println(myIntArray[10]);
    }

}
