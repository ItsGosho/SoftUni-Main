import java.util.Scanner;

public class T04_MaximumSumOf2x2Submatrix {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
         String[] line=skener.nextLine().split(", ");
         int redove=Integer.parseInt(line[0]);
         int koloni=Integer.parseInt(line[1]);
         int[][] matrica=new int[redove][koloni];

         //advane
        for (int red = 0; red < redove; red++) {
            String[] vhod=skener.nextLine().split(", ");
            for (int kol = 0; kol < koloni; kol++) {
                matrica[red][kol] = Integer.parseInt(vhod[kol]);
            }
        }
        //proverka
        String finalTwo1="";
        String finalTwo2="";
        int sum= 0;
        for (int i = 0; i < redove-1; i++) {
            for (int j = 0; j < koloni-1; j++) {
                if(sum<matrica[i][j]+matrica[i][j+1]+matrica[i+1][j]+matrica[i+1][j+1]){
                      sum=matrica[i][j]+matrica[i][j+1]+matrica[i+1][j]+matrica[i+1][j+1];
                      finalTwo1=String.valueOf(matrica[i][j])+" "+String.valueOf(matrica[i][j+1]);
                      finalTwo2=String.valueOf(matrica[i+1][j])+" "+String.valueOf(matrica[i+1][j+1]);
                }
            }
        }
        System.out.println(finalTwo1);
        System.out.println(finalTwo2);
        System.out.println(sum);
    }
}
