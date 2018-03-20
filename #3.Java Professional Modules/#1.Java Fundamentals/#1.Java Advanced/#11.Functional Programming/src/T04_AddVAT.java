import java.util.Scanner;
import java.util.function.Function;

public class T04_AddVAT {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split(", ");
        Function<String,Double> calcVAT=x->Double.parseDouble(x)*1.2;
        System.out.println("Prices with VAT:");
        for (int i = 0; i < line.length; i++) {
            System.out.println(String.format("%.2f", calcVAT.apply(line[i])).replace(".", ","));
        }
    }
}
