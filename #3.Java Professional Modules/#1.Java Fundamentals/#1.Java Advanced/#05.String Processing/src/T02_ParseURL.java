import java.util.Scanner;
import java.util.regex.*;

public class T02_ParseURL {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String line=skener.nextLine();
        Pattern pattern=Pattern.compile("^([^:\\/\\s]+)(:\\/\\/)([^:\\/\\s]+)(\\/)([^:\\s]+)$");
        Matcher check=pattern.matcher(line);
        boolean match=check.find();
        if(match){
            System.out.println("Protocol = "+check.group(1));
            System.out.println("Server = "+check.group(3));
            System.out.println("Resources = "+check.group(5));
        }else{
            System.out.println("Invalid URL");
        }
    }
}
