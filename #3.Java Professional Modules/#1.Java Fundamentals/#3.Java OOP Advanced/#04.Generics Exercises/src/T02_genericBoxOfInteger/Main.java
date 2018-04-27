package T02_genericBoxOfInteger;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        Box<Integer> box=new Box<>();
        int n=Integer.parseInt(skener.nextLine());
        for (int i = 0; i < n; i++) {
            box.add(Integer.parseInt(skener.nextLine()));
        }
        System.out.println(box.toString());
    }
}
