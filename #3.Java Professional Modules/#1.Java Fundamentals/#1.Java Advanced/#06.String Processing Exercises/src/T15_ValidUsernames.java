import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T15_ValidUsernames {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String patternValidUsername="^([A-Za-z]{1})([A-Za-z0-9_]{2,24})$";
        String[] line=skener.nextLine().split("[\\/\\\\() ]+");
        //filter of usernames
        List<String> validUsernames=new ArrayList<>();
        Pattern pattern=Pattern.compile("^([A-Za-z]{1})([A-Za-z0-9_]{2,24})$");
        for (int i = 0; i < line.length; i++) {
            Matcher matcher =pattern.matcher(line[i]);
            if(matcher.find()){
                validUsernames.add(line[i]);
            }
        }
        HashMap<Integer,String> dict=new HashMap<>();
        for (int i = 0; i < validUsernames.size()-1; i++) {
            String word1="";
            String word2="";
            int length=0;
            word1= validUsernames.get(i);
            word2=validUsernames.get(i+1);
            length=word1.length()+word2.length();
            String result=word1+"\n"+word2;
            if(!dict.containsKey(length)){
                  dict.put(length,result);
            }
        }
        String result=Collections.max(dict.entrySet(), Comparator.comparingInt(Map.Entry::getKey)).getValue();
        System.out.println(result);
    }
}
