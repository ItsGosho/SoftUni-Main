import java.util.Scanner;

public class T01_RectangleOf10x10Stars {
    //Gosho---------------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.printf("*");
            }
            System.out.println();
        }
    }
}
