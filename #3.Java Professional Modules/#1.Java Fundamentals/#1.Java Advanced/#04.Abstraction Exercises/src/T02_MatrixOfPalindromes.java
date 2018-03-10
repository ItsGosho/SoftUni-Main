import java.util.Scanner;

public class T02_MatrixOfPalindromes {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] vhod = skener.nextLine().split(" ");
        int redove=Integer.parseInt(vhod[0]);
        int koloni=Integer.parseInt(vhod[1]);

        String[][] matrica=new String[redove][koloni];
        char purvaIPoslednaBukva='a';
        char srednaBukva='a';
        for (int i = 0; i < redove; i++) {

            for (int j = 0; j < koloni; j++) {
                String daSloja="";
                purvaIPoslednaBukva='a';
                purvaIPoslednaBukva+=i;
                srednaBukva='a';
                srednaBukva+=j+i;
                daSloja=String.valueOf(purvaIPoslednaBukva)+String.valueOf(srednaBukva)+String.valueOf(purvaIPoslednaBukva);
                matrica[i][j]=daSloja;
            }
        }
        printiraiMatrica(matrica);
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
