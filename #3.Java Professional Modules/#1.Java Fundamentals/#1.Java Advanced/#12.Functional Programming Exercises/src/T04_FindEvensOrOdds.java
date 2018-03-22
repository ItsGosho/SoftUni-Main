import java.util.Scanner;
import java.util.function.Predicate;

public class T04_FindEvensOrOdds {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(" ");
        int start=Integer.parseInt(line[0]);
        int end=Integer.parseInt(line[1]);
        String oddOrEven=skener.nextLine();
        int one=0;
        if(oddOrEven.equals("even")){
           one=0;
        }else if(oddOrEven.equals("odd")){
            one=1;
        }
        int One = one;
        Predicate<Integer> check= x->x%2== One;
        //fill
        for (int i = start; i <= end; i++) {
             if(check.test(i)){
                 System.out.print(i+" ");
             }
        }
    }
}
