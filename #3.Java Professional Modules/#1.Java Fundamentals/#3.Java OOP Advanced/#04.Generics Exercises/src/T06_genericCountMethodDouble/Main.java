package T06_genericCountMethodDouble;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Box<Double> box=new Box<>();
        int n=Integer.parseInt(skener.nextLine());
        for (int i = 0; i < n; i++) {
             box.add(Double.parseDouble(skener.nextLine()));
        }
        double compareItem=Double.parseDouble(skener.nextLine());
        System.out.println(box.mostOccuries(compareItem));
    }
}
