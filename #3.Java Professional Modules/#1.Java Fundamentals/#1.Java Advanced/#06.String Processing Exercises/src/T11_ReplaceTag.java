import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T11_ReplaceTag {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        while (true) {
            String line = skener.nextLine();
            if (line.equals("END")) {
                break;
            }
            //Pattern pattern = Pattern.compile("(.)*(<a)([^>]+)(>)([^<]+)(<\\/a>)(.)*");
            //Matcher matcher = pattern.matcher(line);
            line = line.replaceFirst("<a", "[URL");
            line = line.replaceFirst("\">", "\"]");
            line = line.replaceFirst("</a>", "[/URL]");
            System.out.println(line);
        }
    }
}
