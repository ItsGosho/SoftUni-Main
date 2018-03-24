import java.util.HashMap;
import java.util.Scanner;

public class T04_SortStudents {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String, String> dict = new HashMap<>();

        while (true) {
            String line = skener.nextLine();
            if (line.equals("END")) {
                break;
            }
            if(!line.equals("")) {
                String[] vhod = line.split(" ");
                String name1 = vhod[0];
                String name2 = vhod[1];
                dict.put(name1, name2);
            }
        }
        dict.entrySet().stream()
                .sorted((x1,x2)->x2.getValue().compareTo(x1.getValue()))
                .sorted((x1,x2)->x1.getKey().compareTo(x2.getKey()))
                .forEach(x1-> System.out.println(x1.getKey()+" "+x1.getValue()));
    }
}
