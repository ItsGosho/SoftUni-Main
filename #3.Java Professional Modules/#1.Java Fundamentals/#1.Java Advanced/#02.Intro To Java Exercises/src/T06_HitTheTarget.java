import java.util.Scanner;

public class T06_HitTheTarget {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int num = skener.nextInt();
        int start = 1;
        for (int i = 1; i < 21; i++) {

            for (int j = 1; j < 21; j++) {
                if (i + j == num) {
                    System.out.printf("%d + %d = %d", i, j, num);
                    System.out.println();
                }else if(i-j==num){
                    System.out.printf("%d - %d = %d", i, j, num);
                    System.out.println();
                }
            }
        }
    }
}
