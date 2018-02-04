import java.util.Scanner;

public class T06_CircleAreaAndPerimeter {
    //Gosho----------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double r = scanner.nextDouble();

        Double area = Math.PI * r * r;
        Double perimeter = 2 * Math.PI * r;

        System.out.printf("Area = %f",area);
        System.out.println();
        System.out.printf("Perimeter = %f",perimeter);

    }
}
