import java.util.Arrays;
import java.util.Scanner;

public class T02_UpperStrings {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Arrays.stream(skener.nextLine().split(" "))
                .map(x->x.toUpperCase())
                .forEach(x-> System.out.print(x+" "));
    }
}
