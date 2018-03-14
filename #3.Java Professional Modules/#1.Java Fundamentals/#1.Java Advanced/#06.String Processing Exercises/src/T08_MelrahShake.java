import java.util.Scanner;

public class T08_MelrahShake {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String text=skener.nextLine();
        String pattern=skener.nextLine();
        StringBuilder str=new StringBuilder();
        while (true){
            //check to end
            int checkIndex=text.lastIndexOf(pattern);
            int checkIndex2=text.indexOf(pattern);
            if(checkIndex ==checkIndex2 || pattern.length()==0){
                System.out.println("No shake.");
                break;
            }
            //delete the borders
            text=text.replaceFirst(pattern,"");
            int lastIndexOfMatch=text.lastIndexOf(pattern);
            str.append(text);
            str=str.delete(lastIndexOfMatch,lastIndexOfMatch+pattern.length());
            text=str.toString();
            str.delete(0,str.length());
            //remove pattern chars
            int removeIndex=pattern.length()/2;
            str.append(pattern);
            str=str.deleteCharAt(removeIndex);
            pattern=str.toString();
            str.delete(0,str.length());
            System.out.println("Shaked it.");
        }
        System.out.println(text);
    }
}
