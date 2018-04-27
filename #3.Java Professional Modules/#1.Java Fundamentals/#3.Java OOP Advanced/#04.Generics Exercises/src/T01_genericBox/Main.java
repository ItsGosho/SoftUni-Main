package T01_genericBox;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        Box<String> box=new Box<>();
        int n=Integer.parseInt(skener.nextLine());
        for (int i = 0; i < n; i++) {
            box.add(skener.nextLine());
        }
        System.out.println(box.toString());
    }
}
