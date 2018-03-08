import java.util.Scanner;

public class T03_SumMatrixElements {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] vhod=skener.nextLine().split(", ");
        int redove=Integer.parseInt(vhod[0]);
        int koloni=Integer.parseInt(vhod[1]);

        int[][] matrica=new int[redove][koloni];
        //vkarvame
        for (int i = 0; i < redove; i++) {
            String[] line=skener.nextLine().split(", ");
            for (int j = 0; j < koloni; j++) {
                matrica[i][j]=Integer.parseInt(line[j]);
            }
        }
        //sumirame
        int totalSum=0;
        for (int red = 0; red < matrica.length; red++) {
            for (int kolona = 0; kolona < matrica[red].length; kolona++) {
                totalSum+=matrica[red][kolona];
            }
        }
        System.out.println(redove);
        System.out.println(koloni);
        System.out.println(totalSum);
    }
}
