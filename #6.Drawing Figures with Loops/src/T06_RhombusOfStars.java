import java.util.Scanner;

public class T06_RhombusOfStars {
    //Gosho---------------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer side = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < side; row++)
        {
            System.out.print(repeatStr(" ",side - row - 1));

            for (int numberOfSymbols = 0; numberOfSymbols <= row; numberOfSymbols++)
            {
                System.out.print(repeatStr("* ", 1));
            }
            System.out.println();
        }
        for (int row = side - 1; row > 0; row--)
        {
            System.out.print(repeatStr(" ",side - row));
            for (int numberOfSymbols = row; numberOfSymbols > 0; numberOfSymbols--)
            {
                System.out.print(repeatStr("* ", 1));
            }
            System.out.println();
        }

    }
    static String repeatStr(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }

}
