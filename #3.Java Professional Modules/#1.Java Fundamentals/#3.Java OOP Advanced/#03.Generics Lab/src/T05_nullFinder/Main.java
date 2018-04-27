package T05_nullFinder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        List<Object> asdBlaba=new ArrayList<>();
        Collections.addAll(asdBlaba,null,1,2,null,5,null);
        System.out.println(ListUtils.getNullIndices(asdBlaba));
    }
}
