import java.util.Scanner;

public class T07_SumSeconds {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Integer first = Integer.parseInt(scanner.nextLine());
        Integer secound = Integer.parseInt(scanner.nextLine());
        Integer third = Integer.parseInt(scanner.nextLine());

        Integer sumSecound = first + secound + third;
        Integer minutes = sumSecound / 60;
        Integer leftSecounds = sumSecound % 60;

        if (leftSecounds < 10) {
            System.out.printf("%d:0%d", minutes,leftSecounds);
        }
        else {
            System.out.printf("%d:%d", minutes,leftSecounds);
        }
    }
}
