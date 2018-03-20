import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class T11_Phonebook {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashMap<String, String> dict = new HashMap<>();
        boolean timeToSearch = false;
        while (true) {
            String line = skener.nextLine();
            if (line.contains("search")) {
                timeToSearch = true;
            }
            if (!timeToSearch) {
                String[] vhod = line.split("-");
                String name = vhod[0];
                String number = vhod[1];
                if (!dict.containsKey(name)) {
                    dict.put(name, number);
                } else {
                    dict.put(name, number);
                }
            } else {
                if (!line.contains("search") && !line.contains("stop")) {
                    String[] vhod = line.split("-");
                    String name = vhod[0];
                    if (!dict.containsKey(name)) {
                        System.out.println("Contact " + name + " does not exist.");
                    } else {
                        System.out.println(name + " -> " + dict.get(name));
                    }
                }
                if(line.contains("stop")) {
                    break;
                }
            }
        }
    }
}
