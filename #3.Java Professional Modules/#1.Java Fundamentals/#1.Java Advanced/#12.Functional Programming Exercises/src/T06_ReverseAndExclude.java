import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class T06_ReverseAndExclude {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line = skener.nextLine().split(" ");
        ArrayList<Integer> arr = new ArrayList();
        for (int i = 0; i < line.length; i++) {
            arr.add(Integer.parseInt(line[i]));
        }
        int toRemoveDiv=Integer.parseInt(skener.nextLine());
        arr=make(arr,toRemoveDiv);
        for (int i = arr.size()-1; i > -1; i--) {
            System.out.print(arr.get(i)+" ");
        }
    }
    public static ArrayList<Integer>  make(ArrayList<Integer> arr,int num){
        ArrayList<Integer> test=new ArrayList<>();
        Function<Integer,Boolean> func=
                x-> x% num != 0;
        for (int i = 0; i < arr.size(); i++) {
            if(func.apply(arr.get(i))){
                test.add(arr.get(i));
            }
        }
        return test;
    }
}
