import java.util.Scanner;

public class T13_AreaOfFigures {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();

        switch (figure) {
            case "square":
                Double side = Double.parseDouble(scanner.nextLine());

                System.out.println(side * side);
                break;
            case "rectangle": {
                Double side1 = Double.parseDouble(scanner.nextLine());
                Double side2 = Double.parseDouble(scanner.nextLine());

                System.out.println(side1 * side2);
                break;
            }
            case "circle":
                Double r = Double.parseDouble(scanner.nextLine());
                System.out.println(Math.PI * r * r);
                break;
            case "triangle": {
                Double side1 = Double.parseDouble(scanner.nextLine());
                Double side2 = Double.parseDouble(scanner.nextLine());

                System.out.println(side1 * side2 / 2);
                break;
            }
        }
    }
}
