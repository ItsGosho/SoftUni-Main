import java.util.Scanner;

public class T01_CalculateTriangleAreaMethod {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        double base=skener.nextDouble();
        double height=skener.nextDouble();
        System.out.printf("Area = %.2f",Calculate(base,height));
    }
    private static double Calculate(double base,double height){
        double result=(base*height)/2;
        return result;
    }
}
