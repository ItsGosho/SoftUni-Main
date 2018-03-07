import java.util.Scanner;

public class T04_CalculateExpression {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        double a=skener.nextDouble();
        double b=skener.nextDouble();
        double c=skener.nextDouble();

        double f1FIRST=((Math.pow(a,2)+Math.pow(b,2))/(Math.pow(a,2)-Math.pow(b,2)));
        double f1SECOND=((a+b+c)/Math.sqrt(c));
        double F1=Math.pow(f1FIRST,f1SECOND);
        double f2FIRST=(Math.pow(a,2)+Math.pow(b,2)-Math.pow(c,3));
        double f2SECOND=(a-b);
        double F2=Math.pow(f2FIRST,f2SECOND);
        double diff=Math.abs(((a+b+c)/3)-((F1+F2)/2));
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f",F1,F2,diff);
    }
}
