import java.util.Scanner;

public class T09_ExtractBitFromInteger {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int num1=skener.nextInt();
        int num2=skener.nextInt();
        int mask=num1>>num2;
        int res=mask & 1;
        System.out.println(res);
    }
}
