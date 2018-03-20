import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class T10_CountSymbols {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String line= skener.nextLine();
        char[] words=line.toCharArray();
        TreeMap<Character,Integer> dict=new TreeMap<>();
        for (int i = 0; i < words.length; i++) {
            if(!dict.containsKey(words[i])){
                  dict.put(words[i],1);
            }else{
                dict.put(words[i],dict.get(words[i])+1);
            }
        }
        for(Map.Entry<Character, Integer> item:dict.entrySet()){
            System.out.println(item.getKey()+": "+item.getValue()+" time/s");
        }
    }
}
