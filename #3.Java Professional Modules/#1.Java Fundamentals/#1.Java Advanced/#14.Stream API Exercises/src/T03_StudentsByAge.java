import java.util.HashMap;
import java.util.Scanner;

public class T03_StudentsByAge {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String, Integer> dict = new HashMap<>();

        while (true) {
            String line = skener.nextLine();
            if (line.equals("END")) {
                break;
            }
            if(!line.equals("")) {
                String[] vhod = line.split(" ");
                String name = vhod[0] + " " + vhod[1];
                int age = Integer.parseInt(vhod[2]);
                dict.put(name, age);
            }
        }
        dict.entrySet().stream().filter(x->x.getValue()>=18 && x.getValue()<=24).sorted((x1,x2)->
        x2.getValue().compareTo(x1.getValue()))
        .forEach(x->{
            String key=x.getKey();
            int age=x.getValue();
            System.out.println(key+" "+age);
        });
    }
}
