import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

public class T11_StringMatrixRotation {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String lineToSplit = skener.nextLine();
        Pattern pattern = Pattern.compile("([0-9]+)");
        Matcher getNumRotation = pattern.matcher(lineToSplit);
        int maxGradusi = 0;
        if (getNumRotation.find()) {
            maxGradusi = Integer.parseInt(getNumRotation.group(0));
        }
        int startGradusi = 0;
        List<String> wordsToPut = new ArrayList<>();
        int naiDulgaDuma = 0;
        while (true) {
            String line = skener.nextLine();
            if (line.equals("END")) {
                break;
            }
            wordsToPut.add(line);
            if (line.length() >= naiDulgaDuma) {
                naiDulgaDuma = line.length();
            }
        }
        int redove = wordsToPut.size();
        int koloni = naiDulgaDuma;
        String[][] matrica = new String[redove][koloni];
        for (int i = 0; i < redove; i++) {
            char[] word = wordsToPut.get(i).toCharArray();
            for (int j = 0; j < word.length; j++) {
                matrica[i][j] = String.valueOf(word[j]);
            }
        }
        String[][] matricaNachalna = matrica.clone();
        String[][] matrica90 = new String[koloni][redove];
        String[][] matrica180 = new String[redove][koloni];
        String[][] matrica270 = new String[koloni][redove];
        //start=0 max=180
        while (true) {

            if (startGradusi == 360) {
                matrica = matricaNachalna.clone();
            }
            if (startGradusi == 90) {
                for (int i = 0; i < matrica90.length; i++) {
                    //i=koloni
                    //j=redove
                    for (int j = 0; j < matrica90[i].length; j++) {
                        matrica90[i][j] = matrica[matrica.length - 1 - j][i];
                    }
                }
            }
            if (startGradusi == 180) {
                for (int i = 0; i < matrica180.length; i++) {
                    for (int j = 0; j < matrica180[i].length; j++) {
                        matrica180[i][matrica180[i].length - 1 - j] = matrica90[j][i];
                    }
                }
            }
            if (startGradusi == 270) {
                for (int i = 0; i < matrica270.length; i++) {
                    //i=koloni
                    //j=redove
                    for (int j = 0; j < matrica270[i].length; j++) {
                        matrica270[i][matrica270[i].length - 1 - j] = matrica180[j][i];
                    }
                }
            }

            if (startGradusi == maxGradusi) {
                if (maxGradusi == 360) {
                    printiraiMatrica(matrica);
                    break;
                } else if (maxGradusi == 90) {
                    printiraiMatrica(matrica90);
                    break;
                } else if (maxGradusi == 180) {
                    printiraiMatrica(matrica180);
                    break;
                } else if (maxGradusi == 270) {
                    printiraiMatrica(matrica270);
                    break;
                }
            }
            if (startGradusi == 360 && maxGradusi>360) {
                maxGradusi -= 360;
                startGradusi = 0;
            }else {
                startGradusi += 90;
            }
        }
    }

    public static void printiraiMatrica(String[][] matrica) {

        for (int i = 0; i < matrica.length; i++) {

            for (int j = 0; j < matrica[i].length; j++) {
                if(matrica[i][j]==null){
                    System.out.print(" ");
                }else {
                    System.out.print(matrica[i][j]);
                }
                }
            System.out.println();
        }
    }
}
