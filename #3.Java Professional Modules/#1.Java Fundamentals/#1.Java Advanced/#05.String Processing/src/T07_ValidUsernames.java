import java.util.Scanner;
import java.util.regex.*;
public class T07_ValidUsernames {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Pattern pattern=Pattern.compile("^([A-Za-z0-9-_]{3,16})$");
        while(true){
            String line=skener.nextLine();
            if(line.equals("END")){
                break;
            }
            Matcher matcher=pattern.matcher(line);
            if(matcher.find()){
                System.out.println("valid");
            }else{
                System.out.println("invalid");
            }
        }
    }
}
