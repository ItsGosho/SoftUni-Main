import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T13_SentenceExtractor {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String pattern=skener.nextLine();
        String text=skener.nextLine();
        Pattern patternreg=Pattern.compile("[A-Z].+?[.!?]");
        Matcher matcher=patternreg.matcher(text);
        while(matcher.find()){
            String toPrint=matcher.group(0);
            String[] found=matcher.group(0).split(" ");
            for (int i = 0; i < found.length; i++) {
                if(found[i].equals(pattern)){
                    System.out.println(toPrint);
                    break;
                }
            }
        }
    }
}
