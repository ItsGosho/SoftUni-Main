import java.util.*;

public class T02_EncryptSortAndPrintArray {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Collection<String> result=new TreeSet<>();
        int n=Integer.parseInt(skener.nextLine());
        String[] names=new String[n];
        for (int i = 0; i < n; i++) {
            names[i]=skener.nextLine();
        }
        for (int i = 0; i <names.length; i++) {
               char[] word=names[i].toCharArray();
            int sum=0;
            for (int j = 0; j < word.length; j++) {
                if(word[j]=='A' || word[j]=='E' || word[j]=='I'|| word[j]=='O'|| word[j]=='U'||
                        word[j]=='a'|| word[j]=='e'|| word[j]=='i'|| word[j]=='o'|| word[j]=='u'){
                    sum+=word[j]*names[i].length();
                }else if(word[j]=='B' || word[j]=='C' || word[j]=='D' || word[j]=='F' || word[j]=='G' || word[j]=='H' || word[j]=='J' || word[j]=='K' || word[j]=='L' || word[j]=='M' || word[j]=='N' || word[j]=='P' || word[j]=='Q' || word[j]=='R' || word[j]=='S' || word[j]=='T' || word[j]=='V' || word[j]=='W' || word[j]=='X' || word[j]=='Y'
                || word[j]=='b' || word[j]=='c' || word[j]=='d' || word[j]=='f' || word[j]=='g' || word[j]=='h' || word[j]=='j' || word[j]=='k' || word[j]=='l' || word[j]=='m' || word[j]=='n' || word[j]=='p' || word[j]=='q' || word[j]=='r' || word[j]=='s' || word[j]=='t' || word[j]=='v' || word[j]=='w' || word[j]=='x' || word[j]=='y'){
                    sum+=word[j]/names[i].length();
                }
            }
                result.add(String.valueOf(sum));
        }
        for(String item:result){
            System.out.println(item);
        }
    }
}
