import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T06_SequenceInMatrix {
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
        List<String> resultDiagonal = new ArrayList<>();
        List<String> resultLine = new ArrayList<>();
        List<String> resultColumn = new ArrayList<>();
        int maxLengthDiagonal = 1;
        String sentence = "";
        String word = matrica[0][0];
        //Diagonals
        int vurti = Math.max(redove, koloni);
        for (int j = 0; j < vurti; j++) {
            try {
                if (maxLengthDiagonal == vurti-2) {
                    resultDiagonal.add(repeatStr(matrica[j][j]+", ",maxLengthDiagonal+1));
                    break;
                }
                if (matrica[j][j].equals(matrica[j - 1][j - 1])) {
                    maxLengthDiagonal++;
                }
            } catch (IndexOutOfBoundsException e) {

            }
        }
        //Lines
        int maxLengthLine = 1;
        for (int i = 0; i < redove; i++) {
            for (int j = 0; j < koloni; j++) {
                try {
                    if (maxLengthLine == koloni) {
                        resultLine.add(repeatStr(matrica[i][j]+", ", maxLengthLine));
                        break;
                    }
                    if (matrica[i][j].equals(matrica[i][j - 1])) {
                        maxLengthLine++;
                    } else {
                        maxLengthLine = 1;
                    }
                } catch (IndexOutOfBoundsException e) {

                }
            }
        }
        //Colums
        int maxLengthColumn = 1;
        for (int i = 0; i < koloni; i++) {
            for (int j = 0; j < redove; j++) {
                if (maxLengthColumn == redove) {
                    resultColumn.add(repeatStr(matrica[j][i]+", ", maxLengthColumn));
                    break;
                }
                try {
                    if (matrica[j][i].equals(matrica[j - 1][i])) {
                        maxLengthColumn++;
                    } else {
                        maxLengthColumn = 1;
                    }
                } catch (IndexOutOfBoundsException e) {

                }
            }
        }
        if(maxLengthDiagonal>maxLengthLine && maxLengthDiagonal>maxLengthLine){
            for(String item:resultDiagonal){
                System.out.println(item);
            }
        }else if(maxLengthLine>maxLengthColumn){
            for(String item:resultLine){
                System.out.println(item);
            }
        }else if(maxLengthColumn>maxLengthLine && maxLengthColumn>maxLengthDiagonal){
            for(String item:resultColumn){
                System.out.println(item);
            }
        }
    }

    static String repeatStr(String strToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + strToRepeat;
        }
        return text;
    }

}
