package T03_genericScale;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Scale<String> scale=new Scale<>("a","b");
        System.out.println(scale.getHeavier());
    }
}
