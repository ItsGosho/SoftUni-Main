import java.util.Scanner;

public class T07_LettersChangeNumbers {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().split("\\s+");
        String lowerCaseAlphabet="abcdefghijklmnopqrstuvwxyz";
        String upperCaseAlphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean smqna=true;
        double totalSum=0;
        for (int i = 0; i < line.length; i++) {
            String numberGET=line[i].substring(1,line[i].length()-1);
            long chislo=Long.parseLong(numberGET);
            char[] seq=line[i].toCharArray();
            //first
            String bukva1=String.valueOf(seq[0]);
            double currentSum=chislo;
            if(lowerCaseAlphabet.contains(bukva1)){
                if(smqna){
                    currentSum+=lowerCaseAlphabet.indexOf(bukva1);
                }else{
                    currentSum*=lowerCaseAlphabet.indexOf(bukva1);
                }
            }else if(upperCaseAlphabet.contains(bukva1)){
                if(smqna){
                    currentSum/=upperCaseAlphabet.indexOf(bukva1);
                }else{
                    currentSum-=upperCaseAlphabet.indexOf(bukva1);
                }
            }
            //second
            String bukva2=String.valueOf(seq[seq.length-1]);
            if(lowerCaseAlphabet.contains(bukva2)){
                if(smqna){
                    currentSum+=lowerCaseAlphabet.indexOf(bukva2);
                    smqna=false;
                }else{
                    currentSum*=lowerCaseAlphabet.indexOf(bukva2);
                    smqna=true;
                }
            }else if(upperCaseAlphabet.contains(bukva2)){
                if(smqna){
                    currentSum/=upperCaseAlphabet.indexOf(bukva2);
                    smqna=false;
                }else{
                    currentSum-=upperCaseAlphabet.indexOf(bukva2);
                    smqna=true;
                }
            }
            totalSum+=currentSum;
        }
        System.out.printf("%.2f",totalSum);
    }
}
