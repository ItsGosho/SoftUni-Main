import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T09_MatchFullName {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        while(true){
           String line=skener.nextLine();
           if(line.equals("end")){
               break;
           }
            Pattern pattern = Pattern.compile("^([A-Z]{1}[a-z]{1,}) ([A-Z]{1}[a-z]{1,})$");
           Matcher matcher=pattern.matcher(line);
           if(matcher.find()){
               System.out.println(line);
           }
        }
    }
}
