import java.util.Scanner;

public class T03_DiagonalDifference {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int size=Integer.parseInt(skener.nextLine());
        int[][] matrica=new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] vhod = skener.nextLine().split(" ");
            for (int j = 0; j < size; j++) {
                matrica[i][j] = Integer.parseInt(vhod[j]);
            }
        }
        int sumLeftDiagonal=0;
        int sumRightDiagonal=0;
        for (int i = 0; i < matrica.length ; i++) {
            for (int j = 0; j < matrica[i].length; j++) {
                 if(i==j){
                     sumLeftDiagonal+=matrica[i][j];
                 }
                 if(matrica[i].length-1==i+j){
                     sumRightDiagonal+=matrica[i][j];
                 }
            }
        }
        int result=Math.max(sumLeftDiagonal,sumRightDiagonal)-Math.min(sumLeftDiagonal,sumRightDiagonal);
        System.out.println(result);
    }
}
