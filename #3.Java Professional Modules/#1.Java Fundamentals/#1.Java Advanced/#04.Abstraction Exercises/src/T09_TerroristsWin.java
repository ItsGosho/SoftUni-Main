import java.util.Scanner;

public class T09_TerroristsWin {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        //  62/100
        String text=skener.nextLine();
        char[] words=text.toCharArray();
        String bomb="";
        boolean getWord=false;
        boolean stopWrod=false;
        String replaceBomb="";
        String replaceBombAfter="";
        StringBuffer buff=new StringBuffer();
        for(char item:words){
            if(item=='|'){
                if(!getWord){
                    replaceBomb+=String.valueOf(item);
                    getWord=true;
                }else{
                    getWord=false;
                    replaceBomb+=String.valueOf(item);
                    replaceBombAfter+=String.valueOf(item);
                    char[] keyWord=bomb.toCharArray();
                    int chislo=0;
                    for (int i = 0; i < keyWord.length; i++) {
                        chislo+=keyWord[i];
                    }
                    String chisloToString=String.valueOf(chislo);
                    char[] asd=String.valueOf(chislo).toCharArray();
                    String lastnum=String.valueOf(asd[asd.length - 1]);
                    //predStringa
                    int toRemove=Integer.parseInt(lastnum);
                    int indexEndRemove=text.indexOf(replaceBomb);
                    //sledString
                    int indexEndRemoveSled=text.indexOf(replaceBombAfter)+replaceBombAfter.length();
                    //----
                    text=text.replace(replaceBomb,repeatStr(".",replaceBomb.length()));
                    //replace
                    buff.append(text);
                    //Ako izleze
                    int formulaPrediEnd=indexEndRemove;
                    if(toRemove>=text.length() || toRemove<=0){
                        break;
                    }
                    int formulaPrediStart=indexEndRemove-toRemove;
                    int formulaSledStart=indexEndRemoveSled;
                    int formulaSledEnd=indexEndRemoveSled+toRemove;
                    if(formulaPrediStart<0){
                        formulaPrediStart=0;
                    }
                    if(formulaSledEnd>=text.length()){
                        formulaSledEnd=text.length()-1;
                    }
                    buff.replace(formulaPrediStart,formulaPrediEnd,repeatStr(".",toRemove));
                   buff.replace(formulaSledStart,formulaSledEnd,repeatStr(".",toRemove));
                    text=buff.toString();
                    buff.delete(0,buff.length());
                    bomb="";
                    replaceBomb="";
                    replaceBombAfter="";
                }
            }
            if(getWord){
                if(item!='|'){
                    replaceBomb+=String.valueOf(item);
                    replaceBombAfter+=String.valueOf(item);
                    bomb+=String.valueOf(item);
                }
            }
        }
        System.out.println(text);
    }
    static String repeatStr(String strToRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + strToRepeat;
        }
        return text;
    }

}
