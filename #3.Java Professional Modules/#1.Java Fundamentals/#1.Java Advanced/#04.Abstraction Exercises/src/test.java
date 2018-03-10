import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        StringBuffer buff=new StringBuffer();
        String line=skener.nextLine(); //29
        String text=line.substring(5,7);
        buff.append(line);
        buff.replace(5,7,repeatStr(".",text.length()));
        System.out.println(buff);
    }
static String repeatStr(String strToRepeat, int count) {
    String text = "";
    for (int i = 0; i < count; i++) {
        text = text + strToRepeat;
    }
    return text;
}

}
