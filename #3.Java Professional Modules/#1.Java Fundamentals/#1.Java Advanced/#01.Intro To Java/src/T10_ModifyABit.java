import java.util.Scanner;

public class T10_ModifyABit {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        int number=skener.nextInt();
        int position=skener.nextInt();
        int value=skener.nextInt();

        int result = 0;
            if (value == 0)
            {
                int mask = ~(1 << position);
                result = number & mask;
            }
            else if (value == 1)
            {
                int mask = 1 << position;
                result = number | mask;
            }
        System.out.println(result);
    }
}
