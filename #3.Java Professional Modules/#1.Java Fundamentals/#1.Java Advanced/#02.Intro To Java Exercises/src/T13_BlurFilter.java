import java.math.BigInteger;
import java.util.Scanner;

public class T13_BlurFilter {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        long blurAmount=Long.parseLong(skener.nextLine());
        String[] vhodSplit1=skener.nextLine().split(" ");
        int redove=Integer.parseInt(vhodSplit1[0]);
        int koloni=Integer.parseInt(vhodSplit1[1]);
        BigInteger[][] matrica=new BigInteger[redove][koloni];
        for (int i = 0; i < redove; i++) {
            String[] vhodSplit2=skener.nextLine().split(" ");
            for (int j = 0; j < koloni; j++) {
               matrica[i][j]=BigInteger.valueOf(Long.parseLong(vhodSplit2[j]));
            }
        }
        String[] vhodSplit3=skener.nextLine().split(" ");
        int redBLUR=Integer.parseInt(vhodSplit3[0]);
        int kolonaBLUR=Integer.parseInt(vhodSplit3[1]);

        try {
            matrica[redBLUR][kolonaBLUR]=matrica[redBLUR][kolonaBLUR].add(BigInteger.valueOf(blurAmount));
            matrica[redBLUR-1][kolonaBLUR]=matrica[redBLUR-1][kolonaBLUR].add(BigInteger.valueOf(blurAmount));
            matrica[redBLUR-1][kolonaBLUR+1]= matrica[redBLUR-1][kolonaBLUR+1].add(BigInteger.valueOf(blurAmount));
            matrica[redBLUR-1][kolonaBLUR-1]=matrica[redBLUR-1][kolonaBLUR-1].add(BigInteger.valueOf(blurAmount));
            matrica[redBLUR][kolonaBLUR-1]=matrica[redBLUR][kolonaBLUR-1].add(BigInteger.valueOf(blurAmount));
            matrica[redBLUR][kolonaBLUR+1]=matrica[redBLUR][kolonaBLUR+1].add(BigInteger.valueOf(blurAmount));
            matrica[redBLUR+1][kolonaBLUR]=matrica[redBLUR+1][kolonaBLUR].add(BigInteger.valueOf(blurAmount));
            matrica[redBLUR+1][kolonaBLUR-1]= matrica[redBLUR+1][kolonaBLUR-1].add(BigInteger.valueOf(blurAmount));
            matrica[redBLUR+1][kolonaBLUR+1]=matrica[redBLUR+1][kolonaBLUR+1].add(BigInteger.valueOf(blurAmount));
        }catch ( IndexOutOfBoundsException e ){
        }

        for (int i = 0; i < redove; i++) {
            for (int j = 0; j < koloni; j++) {
                System.out.print(matrica[i][j]+" ");
            }
            System.out.println();
        }
    }
}
