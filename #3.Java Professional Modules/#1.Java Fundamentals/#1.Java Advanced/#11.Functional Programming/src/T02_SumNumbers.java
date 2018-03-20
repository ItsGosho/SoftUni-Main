
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Function;

public class T02_SumNumbers {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(", ");
        Function<String,Integer> parse= x->Integer.parseInt(x);
        int sum=0;
        int count=0;
        for (int i = 0; i < line.length; i++) {
            sum+=parse.apply(line[i]);
            count++;
        }
        System.out.println("Count = "+count);
        System.out.println("Sum = "+sum);
    }
}
