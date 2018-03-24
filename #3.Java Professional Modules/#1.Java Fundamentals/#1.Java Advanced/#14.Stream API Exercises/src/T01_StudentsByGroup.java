import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Stream;

public class T01_StudentsByGroup {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String, Integer> dict = new HashMap<>();

        while (true) {
            String line = skener.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] vhod = line.split(" ");
            String name = vhod[0] + " " + vhod[1];
            int group = Integer.parseInt(vhod[2]);
            dict.put(name, group);
        }
        HashMap<String, Integer> asd = new HashMap<>();
        dict.entrySet().stream().filter(x1->x1.getValue()==2)
                .sorted((x1,x2)->x1.getKey().compareTo(x2.getKey()))
                .forEach(x->asd.put(x.getKey(),x.getValue()));
        asd.forEach((x1,x2)-> System.out.println(x1));
    }
}
