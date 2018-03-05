import java.util.Scanner;

public class T02_AverageOfThreeNumbers {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        double firstNum=skener.nextDouble();
        double secondNum=skener.nextDouble();
        double thirdNum=skener.nextDouble();
        double avg=(firstNum+secondNum+thirdNum)/3;
        System.out.printf("%.2f",avg);
    }
}
