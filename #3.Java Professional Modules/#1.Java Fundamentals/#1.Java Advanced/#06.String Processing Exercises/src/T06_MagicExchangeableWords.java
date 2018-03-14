import java.util.Scanner;

public class T06_MagicExchangeableWords {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] line=skener.nextLine().toLowerCase().split(" ");
        String dumi1=line[0];
        String dumi2=line[1];
        char[] word1=line[0].toCharArray();
        char[] word2=line[1].toCharArray();
        if(word1.length== word2.length){
                for (int i = 0; i < word1.length; i++) {
                    if(dumi1.length()==0 && dumi2.length()==0){
                        System.out.println("true");
                        break;
                    }else if((dumi1.length()==0 && dumi2.length()!=0) || dumi1.length()!=0 && dumi2.length()==0){
                        System.out.println("false");
                        break;
                    }
                    dumi1=dumi1.replaceAll(String.valueOf(word1[i]),"");
                    dumi2=dumi2.replaceAll(String.valueOf(word2[i]),"");
                }
        }else if(word1.length>word2.length){
            for (int i = 0; i < word1.length; i++) {
                if(dumi1.length()==0 && dumi2.length()==0){
                    System.out.println("true");
                    break;
                }else if((dumi1.length()==0 && dumi2.length()!=0) || dumi1.length()!=0 && dumi2.length()==0){
                    System.out.println("false");
                    break;
                }
                dumi1=dumi1.replaceAll(String.valueOf(word1[i]),"");
                dumi2=dumi2.replaceAll(String.valueOf(word2[i]),"");
            }
        }else if(word1.length<word2.length){
            for (int i = 0; i < word2.length; i++) {
                if(dumi1.length()==0 && dumi2.length()==0){
                    System.out.println("true");
                    break;
                }else if((dumi1.length()==0 && dumi2.length()!=0) || dumi1.length()!=0 && dumi2.length()==0){
                    System.out.println("false");
                    break;
                }
                dumi1=dumi1.replaceAll(String.valueOf(word1[i]),"");
                dumi2=dumi2.replaceAll(String.valueOf(word2[i]),"");
            }
        }
    }
}
