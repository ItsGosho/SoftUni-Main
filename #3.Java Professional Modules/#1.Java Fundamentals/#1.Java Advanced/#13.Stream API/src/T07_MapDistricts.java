import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Stream;

public class T07_MapDistricts {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String, List<Integer>> dict = new HashMap<>();

        String[] line = skener.nextLine().split(" ");
        int numAbove = Integer.parseInt(skener.nextLine());
        for (int i = 0; i < line.length; i++) {
            String[] parsed = line[i].split(":");
            String town = parsed[0];
            int population = Integer.parseInt(parsed[1]);
            if (!dict.containsKey(town)) {
                dict.put(town, new ArrayList<>());
                dict.get(town).add(population);
            } else {
                dict.get(town).add(population);
            }
        }
        Stream<Map.Entry<String, List<Integer>>> test=dict.entrySet()
                .stream()
                .sorted((kv1,kv2)->Integer.compare(kv2.getValue().stream().mapToInt(Integer::intValue).sum(),
                        kv1.getValue().stream().mapToInt(Integer::intValue).sum()))
                .filter(c1->c1.getValue().stream().mapToInt(Integer::intValue).sum()>numAbove)
                ;
        test.forEach(x->{
            String key=x.getKey();
            System.out.print(key+": ");
            x.getValue().sort((x1,x2)->x2.compareTo(x1));
            int dviji=0;
            if(x.getValue().size()>5){
                dviji=5;
            }else{
                dviji=x.getValue().size();
            }
            for (int i = 0; i < dviji; i++) {
                System.out.print(x.getValue().get(i)+" ");
            }
            System.out.println();
        });
    }
}
