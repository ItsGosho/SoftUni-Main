import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class T08_WeakStudents {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        LinkedHashMap<String, List<Integer>> dict = new LinkedHashMap<>();

        while (true) {
            String line = skener.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] vhod = line.split(" ");
            String name = vhod[0] + " " + vhod[1];
            dict.put(name,new ArrayList<>());
            for (int i = 2; i < vhod.length; i++) {
                dict.get(name).add(Integer.parseInt(vhod[i]));
            }
        }
        dict.entrySet().stream().filter(x->{
            boolean itsOk=false;
            int times=0;
            for (int i = 0; i < x.getValue().size(); i++) {
                if(x.getValue().get(i)==2 || x.getValue().get(i)==3){
                    times++;
                }
                if(times==2){
                    itsOk=true;
                }
            }
            return itsOk;
        }).forEach(x-> System.out.println(x.getKey()));
    }
}
