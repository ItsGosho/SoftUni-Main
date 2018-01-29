import java.util.Scanner;

public class T14_TimePlus15Min {
    //Gosho----------------------->
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int hour = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int total = hour * 60 + minutes + 15;
        Integer leftHours = total / 60;
        Integer leftMinutes = total % 60;

        if (leftHours == 24) {
            leftHours = 0;
        }
        if (leftMinutes <= 9) {
            System.out.printf("%d:0%d", leftHours, leftMinutes);
        } else {
            System.out.printf("%d:%d", leftHours, leftMinutes);
        }
    }
}
