import com.sun.deploy.util.StringUtils;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class T06_FindAndSumIntegers {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Predicate<String> proverka = x -> {
            char[] words = x.toCharArray();
            boolean isOk=true;
            List<String> chisla = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
            for (int i = 1; i < x.length(); i++) {
                if ((words[0] == '-' || words[0] == '+' || chisla.contains(words[i]))
                        ) {

                }else{
                    isOk=false;
                }
            }
            return isOk;
        };
        Optional<Integer> vhod = Arrays.stream(skener.nextLine().split(" "))
                .filter(x ->proverka.test(x))
                .map(Integer::valueOf)
                .reduce((c1,c2)->c1+c2);
        if(vhod.isPresent()){
            System.out.println(vhod.get());
        }else{
            System.out.println("No match");
        }
    }
}
