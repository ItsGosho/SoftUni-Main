import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class T14_PopulationCounter {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String,HashMap<String,Integer>> dict=new HashMap<>();
        while(true){
            String line=skener.nextLine();
            if(line.contains("report")){
               break;
            }
            String[] vhod=line.split("[|]");
            String country=vhod[1];
            String city=vhod[0];
            int cityPopulation=Integer.parseInt(vhod[2]);
            if(!dict.containsKey(country)){
               dict.put(country,new LinkedHashMap<String,Integer>());
               dict.get(country).put(city,cityPopulation);
            }else{
                dict.get(country).put(city,cityPopulation);
            }
        }
        dict.entrySet().forEach(c -> {
            System.out.printf("%s (total population: %d)%n",
                    c.getKey(),
                    c.getValue()
                            .values()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum());
        });
    }
}