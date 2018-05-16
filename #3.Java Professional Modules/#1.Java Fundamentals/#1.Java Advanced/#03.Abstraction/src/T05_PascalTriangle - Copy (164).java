import java.util.Scanner;

public class T05_PascalTriangle {
    //Gosho------------------------------>
    public static void main(String[] args) {
        // 60/100 защото не трябва да е с long а със BigInteger (Не ми се занимаваше просто ;d)
        Scanner skener = new Scanner(System.in);
        int n = Integer.parseInt(skener.nextLine());

        long[][] zona = new long[n][n];
        for (int red = 0; red < n; red++) {
            zona[red][0]=1;
            for (int kolona = 0; kolona < red ; kolona++) {
                long num = zona[red - 1][kolona] + zona[red - 1][kolona + 1];
                zona[red][kolona+1] = num;
            }
        }
        for (int i = 0; i < zona.length; i++) {

            for (int j = 0; j < zona[i].length; j++) {
                if(zona[i][j]!=0){
                    System.out.print(zona[i][j]+" ");
                }
            }
            System.out.println();
        }
    }
}