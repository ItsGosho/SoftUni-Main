import java.util.HashMap;
import java.util.Scanner;

public class T06_FilterStudentsByPhone {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String, String> dict = new HashMap<>();

        while (true) {
            String line = skener.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] vhod = line.split(" ");
            String name = vhod[0] + " " + vhod[1];
            String telephone = vhod[2];
            dict.put(name, telephone);
        }
        dict.entrySet().stream().filter(x -> x.getValue().startsWith("02")
                || x.getValue().startsWith("+3592"))
                .sorted((x1,x2)->x2.getKey().compareTo(x1.getKey()))
                .forEach(x -> System.out.println(x.getKey()));
    }
}
