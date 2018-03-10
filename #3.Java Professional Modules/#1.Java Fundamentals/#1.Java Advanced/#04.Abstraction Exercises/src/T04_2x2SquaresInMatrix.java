import java.util.Arrays;
import java.util.Scanner;

public class T04_2x2SquaresInMatrix {
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
        int broi = 0;
        for (int i = 0; i < redove; i++) {
            for (int j = 0; j < koloni; j++) {
                try {
                    if (matrica[i][j].equals(matrica[i][j + 1])
                            && matrica[i][j].equals(matrica[i + 1][j])
                            && matrica[i][j].equals(matrica[i + 1][j + 1])) {
                        broi++;
                    }
                } catch (IndexOutOfBoundsException e) {
                }
            }
        }
        System.out.println(broi);
    }
}
