import java.util.Scanner;

public class T05_MaximalSum {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] vhod = skener.nextLine().split(" ");
        int redove = Integer.parseInt(vhod[0]);
        int koloni = Integer.parseInt(vhod[1]);
        int[][] matrica = new int[redove][koloni];
        for (int i = 0; i < redove; i++) {
            String[] vhod2 = skener.nextLine().split(" ");
            for (int j = 0; j < koloni; j++) {
                matrica[i][j] = Integer.parseInt(vhod2[j]);
            }
        }
        int maxSum= Integer.MIN_VALUE;
        String firstRow="";
        String secondRow="";
        String thirdRow="";
        for (int i = 0; i < redove; i++) {

            for (int j = 0; j < koloni; j++) {
                try{
                    if(matrica[i][j]+matrica[i][j+1]+matrica[i][j+2]
                    +matrica[i+1][j]+matrica[i+1][j+1]+matrica[i+1][j+2]
                            +matrica[i+2][j]+matrica[i+2][j+1]+matrica[i+2][j+2]>maxSum){
                        maxSum=matrica[i][j]+matrica[i][j+1]+matrica[i][j+2]
                                +matrica[i+1][j]+matrica[i+1][j+1]+matrica[i+1][j+2]
                                +matrica[i+2][j]+matrica[i+2][j+1]+matrica[i+2][j+2];
                        firstRow=String.valueOf(matrica[i][j])+" "+String.valueOf(matrica[i][j+1])+" "+String.valueOf(matrica[i][j+2]);
                        secondRow=String.valueOf(matrica[i+1][j])+" "+String.valueOf(matrica[i+1][j+1])+" "+String.valueOf(matrica[i+1][j+2]);
                        thirdRow=String.valueOf(matrica[i+2][j])+" "+String.valueOf(matrica[i+2][j+1])+" "+String.valueOf(matrica[i+2][j+2]);

                    }
                }catch(IndexOutOfBoundsException e){

                }
            }
        }
        System.out.println("Sum = "+maxSum);
        System.out.println(firstRow);
        System.out.println(secondRow);
        System.out.println(thirdRow);
    }
}
