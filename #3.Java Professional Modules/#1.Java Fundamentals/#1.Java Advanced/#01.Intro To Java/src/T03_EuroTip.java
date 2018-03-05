import java.math.BigDecimal;
import java.util.Scanner;

public class T03_EuroTip {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        double broi=Double.parseDouble(skener.nextLine());
        BigDecimal broiToDec=new BigDecimal(broi*1.20);
        BigDecimal markPrice=new BigDecimal("4210500000000");
        broiToDec=broiToDec.multiply(markPrice);
        System.out.printf("%.2f marks",broiToDec);
    }
}
