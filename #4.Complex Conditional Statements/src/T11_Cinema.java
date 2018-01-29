import java.util.Scanner;

public class T11_Cinema {
    //Gosho--------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String projectionType = scanner.nextLine().toLowerCase();
        int rowsCount = Integer.parseInt(scanner.nextLine());
        int columnsCount = Integer.parseInt(scanner.nextLine());

        int fullCapacity = rowsCount * columnsCount;
        double income = 0;

        switch (projectionType) {
            case "premiere":
                income = fullCapacity * 12.00;
                break;
            case "normal":
                income = fullCapacity * 7.50;
                break;
            case "discount":
                income = fullCapacity * 5.00;
                break;
        }
        System.out.printf("%.2f leva", income);
    }
}
