import java.math.BigInteger;
import java.util.Scanner;

public class T04_CombinationsCount {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int n=Integer.parseInt(skener.nextLine());
        int r=Integer.parseInt(skener.nextLine());
        //up
        BigInteger upResult=new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            upResult=upResult.multiply(BigInteger.valueOf(i));
        }
        //firstR
        BigInteger firstR=new BigInteger("1");
        for (int i = 1; i <= r; i++) {
            firstR=firstR.multiply(BigInteger.valueOf(i));
        }
        BigInteger skobi=new BigInteger("1");
        long resultBetweenThem=n-r;
        for (int i = 1; i <= resultBetweenThem; i++) {
            skobi=skobi.multiply(BigInteger.valueOf(i));
        }
        firstR=firstR.multiply(skobi);
        upResult=upResult.divide(firstR);
        System.out.println(upResult);
    }
}
