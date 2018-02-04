import java.util.Scanner;

public class T11_USDtoBGN {
    //Gosho----------------->
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
        Double dollars = Double.parseDouble(scanner.nextLine());

        Double leva = dollars * 1.79549;
        System.out.printf("%.2f BGN", leva);
    }
}
