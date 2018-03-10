
import java.util.Scanner;
import java.util.regex.*;

public class T08_MatrixShuffiling {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] vhod = skener.nextLine().split(" ");
        int redove = Integer.parseInt(vhod[0]);
        int koloni = Integer.parseInt(vhod[1]);
        String[][] matrica = new String[redove][koloni];
        for (int i = 0; i < redove; i++) {
            String[] vhod2 = skener.nextLine().split(" ");
            for (int j = 0; j < koloni; j++) {
                matrica[i][j] = vhod2[j];
            }
        }
        String pattern="(swap )([0-9]+ [0-9]+ [0-9]+ [0-9]+)";
        while(true){
            String line=skener.nextLine();
            if(line.equals("END")){
                break;
            }
            Matcher valid = Pattern.compile("(swap )([0-9]+ [0-9]+ [0-9]+ [0-9]+)").matcher(line);
            if(valid.find()){
                String[] vhod2=line.split(" ");
                int row1=Integer.parseInt(vhod2[1]);
                int col1=Integer.parseInt(vhod2[2]);
                int row2=Integer.parseInt(vhod2[3]);
                int col2=Integer.parseInt(vhod2[4]);
                if(row1<=matrica.length && row2<=matrica.length && col1<=matrica[row2].length && col2<=matrica[row1].length){
                    String vremenna=matrica[row1][col1];
                    matrica[row1][col1]=matrica[row2][col2];
                    matrica[row2][col2]=vremenna;
                    printiraiMatrica(matrica);
                }else{
                    System.out.println("Invalid input!");
                }
            }else{
                System.out.println("Invalid input!");
            }
        }
    }
    public static void printiraiMatrica(String[][] matrica){

        for (int i = 0; i < matrica.length; i++) {

            for (int j = 0; j < matrica[i].length; j++) {
                System.out.print(matrica[i][j]+" ");
            }
            System.out.println();
        }
    }
}
