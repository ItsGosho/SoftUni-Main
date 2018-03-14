import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T10_MatchPhoneNumber {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        while(true){
            String line=skener.nextLine();
            if(line.equals("end")){
                break;
            }
            Pattern pattern = Pattern.compile("^(\\+359)(\\ |\\-)(2)(\\2)([0-9]{3})(\\2)([0-9]{4})$");
            Matcher matcher=pattern.matcher(line);
            if(matcher.find()){
                System.out.println(line);
            }
        }
    }
}
