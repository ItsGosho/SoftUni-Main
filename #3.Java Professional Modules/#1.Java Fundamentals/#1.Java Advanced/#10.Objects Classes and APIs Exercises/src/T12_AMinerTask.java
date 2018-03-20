import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T12_AMinerTask {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String, Integer> dict = new HashMap<>();
        while (true) {
            String line = skener.nextLine();
            if (line.contains("stop")) {
                break;
            }
            String type=line;
            int total=Integer.parseInt(skener.nextLine());
            if(!dict.containsKey(type)){
               dict.put(type,total);
            }else{
                dict.put(type,dict.get(type)+total);
            }
        }
        for(Map.Entry<String, Integer> item:dict.entrySet()){
            System.out.println(item.getKey()+" -> "+item.getValue());
        }
    }
}
