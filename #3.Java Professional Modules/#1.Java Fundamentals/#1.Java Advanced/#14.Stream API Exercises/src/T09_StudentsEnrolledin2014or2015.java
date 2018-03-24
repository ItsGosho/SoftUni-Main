import java.util.*;

public class T09_StudentsEnrolledin2014or2015 {
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
            String codeName = vhod[0];
            dict.put(codeName, new ArrayList<>());
            for (int i = 1; i < vhod.length; i++) {
                dict.get(codeName).add(Integer.parseInt(vhod[i]));
            }
        }
        dict.entrySet().stream().filter(x -> x.getKey().endsWith("14")
                || x.getKey().endsWith("15"))
                .forEach(x -> {
                    for (int i = 0; i < x.getValue().size(); i++) {
                        System.out.print(x.getValue().get(i)+" ");
                    }
                    System.out.println();
                });
    }
}
