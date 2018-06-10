import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);


        Map<String,Long> dict=new LinkedHashMap<>();
        while (true) {
            String line = skener.nextLine();
            if (line.equals("Stop!")) {
                break;
            }
            Matcher matcher=Pattern.compile("^([!@#$?a-z]+)(=)([0-9]+)(--)([0-9]+)(<<)([a-z]+)$")
                    .matcher(line);
            if(matcher.find()){
                  String nameToCheckForLength=matcher.group(1);
                  int nameNeededLength=Integer.parseInt(matcher.group(3));
                  long genomeSize=Long.parseLong(matcher.group(5));
                  String animalName=matcher.group(7);

                Matcher matcherForWord=Pattern.compile("[a-z]").matcher(nameToCheckForLength);

                String toCheck="";
                while(matcherForWord.find()){
                    toCheck+=matcherForWord.group(0);
                }
                //succed
                if(toCheck.length()==nameNeededLength){
                    if(dict.containsKey(animalName)){
                        dict.put(animalName,dict.get(animalName)+genomeSize);
                    }else{
                        dict.put(animalName,genomeSize);
                    }
                }
            }
        }
        dict.entrySet().stream().sorted((x1,x2)->{
            if(x1.getValue()==x2.getValue()){
                return 0;
            }else{
                return Long.compare(x2.getValue(),x1.getValue());
            }
        })
                .forEach(x->{
                    System.out.println(x.getKey()+" has genome size of "+x.getValue());
                });
    }
}