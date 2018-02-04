import java.util.Scanner;

public class T07_2DRectangleArea {
    //Gosho----------------->
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        Double x1 = Double.parseDouble(scanner.nextLine());
        Double y1 = Double.parseDouble(scanner.nextLine());
        Double x2 = Double.parseDouble(scanner.nextLine());
        Double y2 = Double.parseDouble(scanner.nextLine());

        Double area = Math.abs(x1 - x2) * Math.abs(y1 - y2);
        Double perimeter = 2 * (Math.abs(x1 - x2) + Math.abs(y1 - y2));

        System.out.println(area);
        System.out.println(perimeter);
    }
}
