import java.util.Scanner;

public class T01_FillTheMatrix {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] vhod = skener.nextLine().split(", ");
        int size=Integer.parseInt(vhod[0]);
        String type=vhod[1];
        long[][] matrica=new long[size][size];
        if(type.equals("A")){
           fillA(matrica);
        }else if(type.equals("B")){
          fillB(matrica);
        }
    }
    private static long[][] fillA(long[][] matrica){
        int[][] typeA={{1,5,9,13},{2,6,10,14},{3,7,11,15},{4,8,12,16}};

        int tipRed=0;
        int tipKol=0;
        int kamik=1;
        for (int i = 0; i < matrica.length; i++) {
            for (int j = 0; j < matrica[i].length; j++) {
                matrica[j][i]=kamik;
                kamik++;
            }
        }
        printiraiMatrica(matrica);
        return matrica;
    }
    private static long[][] fillB(long[][] matrica){
        int b=1;
        int zapochni=0;
        int poMalko=0;
        int kamik=1;
        for (int i = 0; i < matrica.length; i++) {
            if (i%2!=0) {
                b=-1;
                zapochni=matrica.length-1;
                poMalko=-1;
                for (int j = zapochni; j > poMalko; j+=b) {
                    matrica[j][i]=kamik;
                    kamik++;
                }
            }else{
                b=1;
                zapochni=0;
                poMalko=matrica[i].length;
                for (int j = zapochni; j < poMalko; j+=b) {
                    matrica[j][i]=kamik;
                    kamik++;
                }
            }
        }
        printiraiMatrica(matrica);
        return matrica;
    }
    public static void printiraiMatrica(long[][] matrica){

        for (int i = 0; i < matrica.length; i++) {

            for (int j = 0; j < matrica[i].length; j++) {
                System.out.print(matrica[i][j]+" ");
            }
            System.out.println();
        }
    }
}
