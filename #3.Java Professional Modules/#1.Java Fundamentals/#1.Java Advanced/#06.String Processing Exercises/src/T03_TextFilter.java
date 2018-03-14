import java.util.Scanner;

public class T03_TextFilter {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] baneedWords=skener.nextLine().split(", ");
        String text=skener.nextLine();
        for (int i = 0; i < baneedWords.length; i++) {
            text=text.replace(baneedWords[i],repeatStr("*",baneedWords[i].length()));
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
