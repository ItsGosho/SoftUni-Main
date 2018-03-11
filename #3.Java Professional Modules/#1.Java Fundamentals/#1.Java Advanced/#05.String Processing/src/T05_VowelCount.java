import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Scanner;
import java.util.regex.*;

public class T05_VowelCount {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String line=skener.nextLine();
        Pattern pattern=Pattern.compile("[AEIOUYaeiouy]");
        Matcher match = pattern.matcher(line);
        int count=0;
        while(match.find()){
            count++;
        }
        System.out.println("Vowels: "+count);
    }
}
