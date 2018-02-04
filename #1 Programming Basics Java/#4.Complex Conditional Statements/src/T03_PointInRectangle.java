import java.util.Scanner;

public class T03_PointInRectangle {
    //Gosho--------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double x1 = Double.parseDouble(scanner.nextLine());
        Double y1 = Double.parseDouble(scanner.nextLine());
        Double x2 = Double.parseDouble(scanner.nextLine());
        Double y2 = Double.parseDouble(scanner.nextLine());
        Double x = Double.parseDouble(scanner.nextLine());
        Double y = Double.parseDouble(scanner.nextLine());

        if (x1 <= x && x <= x2&&y1 <= y && y<= y2){
            System.out.printf("Inside");
        }
        else {
            System.out.printf("Outside");
        }
    }
}
