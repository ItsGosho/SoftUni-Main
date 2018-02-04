import java.util.Scanner;

public class T02_BooleanVariable {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Boolean boolResult = Boolean.parseBoolean(scan.nextLine());
        if (boolResult)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
