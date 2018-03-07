import java.text.DecimalFormat;
import java.util.Scanner;

public class T03_FormatingNumbers {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int a=skener.nextInt();
        double b=skener.nextDouble();
        double c=skener.nextDouble();

        String aToHEX=Integer.toHexString(a).toUpperCase();
        String aToBinaryParse=Integer.toBinaryString(a);
        int dobavi=aToBinaryParse.length();
        int trebva=10-dobavi;
        String aToBinary=repeatStr("0",trebva)+aToBinaryParse;
        int kol1Length=10-aToHEX.length();
        String kol1=repeatStr(" ",kol1Length);
        DecimalFormat dfForB = new DecimalFormat("0.00");
        DecimalFormat dfForC = new DecimalFormat("0.000");
        String stringedB = dfForB.format(b);
        String stringedC = dfForC.format(c);
        String kol2=repeatStr(" ",10-stringedB.length());
        String kol3=repeatStr(" ",10-stringedC.length());
        System.out.printf("|%s%s|%s|%s%.2f|%.3f%s|",aToHEX,kol1,aToBinary,kol2,b,c,kol3);
    }
    static String repeatStr(String strToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + strToRepeat;
        }
        return text;
    }

}
