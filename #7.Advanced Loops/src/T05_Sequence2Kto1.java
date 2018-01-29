import java.util.Scanner;

public class T05_Sequence2Kto1 {
    //Gosho------------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer n = Integer.parseInt(scanner.nextLine());

        Integer num = 1;
        while (num<=n){
            System.out.println(num);
            num = num * 2 + 1;
        }
    }
}
