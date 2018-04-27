package T04_listUtilities;

import java.util.*;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        List<Integer> items=new ArrayList<>();
        Collections.addAll(items,1,2,3,4,5);
        System.out.println(ListUtils.getMax(items));
    }
}
