package T07_foodShortage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        List<Buyer> db = new ArrayList<>();
        int n = Integer.parseInt(skener.nextLine());
        for (int i = 0; i < n; i++) {
            String line = skener.nextLine();
            String[] vhod = line.split(" ");
            if (vhod.length == 4) {
                String name = vhod[0];
                String age = vhod[1];
                String id = vhod[2];
                String birthday = vhod[3];
                db.add(new Human(name, age, id, birthday));
            } else if (vhod.length == 3) {
                String name = vhod[0];
                String age = vhod[1];
                String group = vhod[2];
                db.add(new Rebel(name, age, group));
            }
        }
        while (true) {
            String person = skener.nextLine();
            if (person.equals("End")) {
                break;
            }
            db.stream().filter(x -> x.getName().equals(person)).forEach(x -> x.buyFood());
        }
        int totalFood = db.stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
