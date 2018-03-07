import java.util.Scanner;

public class T07_CharacterMultiplier {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String first=skener.next();
        String second=skener.next();
        char[] firstToChar=first.toCharArray();
        char[] secondToChar=second.toCharArray();
        int sum=0;
        if(firstToChar.length==secondToChar.length){
            for (int i = 0; i < firstToChar.length; i++) {
               sum+=firstToChar[i]*secondToChar[i];
            }
            System.out.println(sum);
        }else if(firstToChar.length>secondToChar.length){
            int cont=0;
            for (int i = 0; i < secondToChar.length; i++) {
                sum+=firstToChar[i]*secondToChar[i];
                cont=i;
            }
            for (int j = cont+1; j < firstToChar.length; j++) {
                sum+=firstToChar[j];
            }
            System.out.println(sum);
        }else if(firstToChar.length<secondToChar.length){
            int cont=0;
            for (int i = 0; i < firstToChar.length; i++) {
                sum+=firstToChar[i]*secondToChar[i];
                cont=i;
            }
            for (int j = cont+1; j < secondToChar.length; j++) {
                sum+=secondToChar[j];
            }
            System.out.println(sum);
        }
    }
}
