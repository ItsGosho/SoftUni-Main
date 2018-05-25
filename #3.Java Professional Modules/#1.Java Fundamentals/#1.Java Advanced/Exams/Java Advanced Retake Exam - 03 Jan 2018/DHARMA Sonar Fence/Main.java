import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Delete {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        while (true) {
            String line = skener.nextLine();
            if (line.equals("Reprogram")) {
                break;
            }
            BigInteger vhod = new BigInteger(line);
            String inBit=vhod.toString(2);
            String full=String.format("%32s", inBit);
            full=full.replace(" ","0");
            char[] word=full.toCharArray();
            String result="";
            for (int i = 0; i < full.length(); i++) {
                try {
                    if (String.valueOf(word[i]).equals(String.valueOf(word[i + 1]))) {
                        String stoinost = String.valueOf(word[i]) + String.valueOf(word[i + 1]);
                        if (stoinost.equals("11")) {
                            result += "00";
                        } else {
                            result += "11";
                        }
                        i++;
                    } else {
                        result += word[i];
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    result += word[i];
                }
            }
            BigInteger res=new BigInteger(result,2);
            System.out.println(res);
        }
    }
}