import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class T09_CustomComparator {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {
            if (!line[i].equals("")) {
                arr.add(Integer.parseInt(line[i]));
            }
        }
        ArrayList<Integer> evenNums = new ArrayList<>();
        ArrayList<Integer> oddNums = new ArrayList<>();
        Predicate<Integer> even= x->x%2==0;
        for (int i = 0; i < arr.size(); i++) {
            if(even.test(arr.get(i))){
                evenNums.add(arr.get(i));
                evenNums.sort((x1,x2)->x1.compareTo(x2));
            }else{
                oddNums.add(arr.get(i));
                oddNums.sort((x1,x2)->x1.compareTo(x2));
            }
        }
        for (int i = 0; i < evenNums.size(); i++) {
            System.out.print(evenNums.get(i)+" ");
        }
        for (int i = 0; i < oddNums.size(); i++) {
            System.out.print(oddNums.get(i)+" ");
        }
    }
}
