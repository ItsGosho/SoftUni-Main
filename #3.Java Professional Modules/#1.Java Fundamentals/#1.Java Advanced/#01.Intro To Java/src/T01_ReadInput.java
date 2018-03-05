import java.util.Scanner;

public class T01_ReadInput {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstString = scanner.next();
        String secondString = scanner.next();
        int num1= scanner.nextInt();
        int num2=scanner.nextInt();
        int num3=scanner.nextInt();
        int sum=num1+num2+num3;
        String lastString = scanner.next();
        System.out.println(firstString + " " + secondString+" "+lastString+" "+sum);
    }
}
