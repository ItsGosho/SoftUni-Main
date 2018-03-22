import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class T03_CustomMinFunction {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(" ");
        Function<String[],Integer> minFunc=x->{
            ArrayList<Integer> arr=new ArrayList<>();
            for (int i = 0; i < x.length; i++) {
                arr.add(Integer.parseInt(x[i]));
            }
            arr.sort((x1,x2)->x1.compareTo(x2));
            return arr.get(0);
        };
        System.out.println(minFunc.apply(line));
    }
}
