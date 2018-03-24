import java.util.*;

public class T07_ExcellentStudents {
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
        dict.entrySet().stream().filter(x->x.getValue().contains(6))
                .forEach(x-> System.out.println(x.getKey()));
    }
}
