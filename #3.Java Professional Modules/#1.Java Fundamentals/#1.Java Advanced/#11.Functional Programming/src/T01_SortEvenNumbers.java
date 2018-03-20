import com.sun.deploy.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class T01_SortEvenNumbers {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(", ");
        ArrayList<Integer> nums=new ArrayList<>();
        for(String item:line){
            nums.add(Integer.parseInt(item));
        }
        nums.removeIf(x->x%2!=0);
        System.out.println(Arrays.toString(nums.toArray()).replace("[","").replace("]",""));
        System.out.println();
        nums.sort((x1,x2)->x1.compareTo(x2));
        System.out.println(Arrays.toString(nums.toArray()).replace("[","").replace("]",""));
    }
}
