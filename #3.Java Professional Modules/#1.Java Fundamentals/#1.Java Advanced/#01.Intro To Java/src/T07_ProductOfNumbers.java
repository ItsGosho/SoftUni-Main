import java.math.BigInteger;
import java.util.Scanner;

public class T07_ProductOfNumbers {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int num1=skener.nextInt();
        int num2=skener.nextInt();
        String placeH1=String.valueOf(num1);
        String placeH2=String.valueOf(num2);
        BigInteger result=new BigInteger(String.valueOf(num1));
        do {
            num1++;
           result=result.multiply(BigInteger.valueOf(num1));
        }while(num1<num2);
        System.out.printf("product[%s..%s] = %d",placeH1,placeH2,result);
    }
}
