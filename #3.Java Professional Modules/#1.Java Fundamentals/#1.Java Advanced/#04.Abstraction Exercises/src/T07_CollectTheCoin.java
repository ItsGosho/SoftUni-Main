import java.util.Scanner;

public class T07_CollectTheCoin {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String rowFirst = skener.nextLine();
        String rowSecond = skener.nextLine();
        String rowThird = skener.nextLine();
        String rowFour = skener.nextLine();
        String moves = skener.nextLine();
        char[] hodove = moves.toCharArray();
        int maxDuljinaNaPoleto = Math.max(Math.max(rowFirst.length(), rowSecond.length()), Math.max(rowThird.length(), rowFour.length()));
        String[][] matrica = new String[4][maxDuljinaNaPoleto];
        vkaraiVMatricata(rowFirst, rowSecond, rowThird, rowFour, matrica, maxDuljinaNaPoleto);

        int poziciqRed=0;
        int poziciqKolona=0;
        int money=0;
        int walls=0;
        if(matrica[0][0].equals("$")){
            money++;
        }
        for (int i = 0; i < hodove.length; i++) {
            if(hodove[i]=='V'){
                poziciqRed++;
                if(poziciqRed==4 || matrica[poziciqRed][poziciqKolona]==null){
                    walls++;
                    poziciqRed--;
                }else{
                    if(matrica[poziciqRed][poziciqKolona].equals("$")){
                        money++;
                    }
                }
            }else if(hodove[i]=='>'){
                poziciqKolona++;
                if(poziciqKolona==matrica[poziciqRed].length  || matrica[poziciqRed][poziciqKolona]==null){
                    walls++;
                    poziciqKolona--;
                }else{
                    if(matrica[poziciqRed][poziciqKolona].equals("$")){
                        money++;
                    }
                }
            }else if(hodove[i]=='^'){
                poziciqRed--;
                if(poziciqRed==-1 || matrica[poziciqRed][poziciqKolona]==null){
                    walls++;
                    poziciqRed++;
                }else{
                    if(matrica[poziciqRed][poziciqKolona].equals("$")){
                        money++;
                    }
                }

            }else if(hodove[i]=='<'){
                poziciqKolona--;
                if(poziciqKolona==-1 || matrica[poziciqRed][poziciqKolona]==null){
                    walls++;
                    poziciqRed++;
                }else{
                    if(matrica[poziciqRed][poziciqKolona].equals("$")){
                        money++;
                    }
                }
            }
        }
        System.out.println("Coins = "+money);
        System.out.println("Walls = "+walls);
    }

    public static void printiraiMatrica(String[][] matrica) {

        for (int i = 0; i < matrica.length; i++) {

            for (int j = 0; j < matrica[i].length; j++) {
                System.out.print(matrica[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] vkaraiVMatricata(String rowFirst, String rowSecond, String rowThird, String rowFour, String[][] matrica, int maxDuljinaNaPoleto) {
        char[] purviRed = rowFirst.toCharArray();
        char[] vtoriRed = rowSecond.toCharArray();
        char[] tretiRed = rowThird.toCharArray();
        char[] chetvurtiRed = rowFour.toCharArray();
        int now = 0;
        int dulj = Integer.MAX_VALUE;
        for (int i = 0; i < matrica.length; i++) {
            now++;
            for (int j = 0; j < dulj; j++) {
                if (now == 1) {
                    dulj = purviRed.length;
                    matrica[i][j] = String.valueOf(purviRed[j]);
                } else if (now == 2) {
                    dulj = vtoriRed.length;
                    matrica[i][j] = String.valueOf(vtoriRed[j]);
                } else if (now == 3) {
                    dulj = tretiRed.length;
                    matrica[i][j] = String.valueOf(tretiRed[j]);
                } else if (now == 4) {
                    dulj = chetvurtiRed.length;
                    matrica[i][j] = String.valueOf(chetvurtiRed[j]);
                }
            }
        }
        return matrica;
    }
}
