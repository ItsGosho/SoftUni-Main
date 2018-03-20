import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class T04_FilterByAge {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
       int n=Integer.parseInt(skener.nextLine());
        Map<String,Integer> dict=new LinkedHashMap<>();
       int counter=0;
       while(counter<n){
           String[] line=skener.nextLine().split(", ");
           String name=line[0];
           int age=Integer.parseInt(line[1]);
           dict.put(name,age);
           counter++;
       }
       String youngOld=skener.nextLine();
       int age=Integer.parseInt(skener.nextLine());
       String format=skener.nextLine();
       switch(youngOld){
           case "younger":
               switch(format){
                   case "age":
                       List<Integer> result=dict.entrySet().stream()
                               .filter(x->x.getValue()<age).map(Map.Entry::getValue).collect(Collectors.toList());
                       for (int i = 0; i < result.size(); i++) {
                           System.out.println(result.get(i));
                       }
                       format="";
                       break;
                   case "name":
                       List<String> name=dict.entrySet().stream().filter(x->x.getValue()<age).map(Map.Entry::getKey).collect(Collectors.toList());
                       System.out.println(String.join("\n",name));
                       format="";
                       break;
                   case "name age":
                       dict.entrySet().removeIf(x->x.getValue()>=age);
                       for(Map.Entry<String, Integer> item:dict.entrySet()){
                           System.out.println(item.getKey()+" - "+item.getValue());
                       }
                       format="";
                       break;
               }
           case "older":
               switch (format) {
                   case "age":
                       List<Integer> result = dict.entrySet().stream()
                               .filter(x -> x.getValue() >= age).map(Map.Entry::getValue).collect(Collectors.toList());
                       for (int i = 0; i < result.size(); i++) {
                           System.out.println(result.get(i));
                       }
                       format="";
                       break;
                   case "name":
                       List<String> name = dict.entrySet().stream().filter(x -> x.getValue() >= age).map(Map.Entry::getKey).collect(Collectors.toList());
                       System.out.println(String.join("\n", name));
                       format="";
                       break;
                   case "name age":
                       dict.entrySet().removeIf(x->x.getValue()<age);
                       for (Map.Entry<String, Integer> item : dict.entrySet()) {
                           System.out.println(item.getKey() + " - " + item.getValue());
                       }
                       format="";
                       break;
               }
       }
    }
}
