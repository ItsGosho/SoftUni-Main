import java.util.Scanner;

public class T08_TriangleArea {
    //Gosho----------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double triangleSide = Double.parseDouble(scanner.nextLine());
        Double height = Double.parseDouble(scanner.nextLine());

        Double area = (triangleSide * height) / 2;

        System.out.printf("Triangle area = %.2f",area);
    }
}
