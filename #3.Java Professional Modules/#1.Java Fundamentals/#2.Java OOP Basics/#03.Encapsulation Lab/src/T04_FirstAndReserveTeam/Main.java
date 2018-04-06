package T04_FirstAndReserveTeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();
        int n = Integer.parseInt(skener.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = skener.nextLine().split(" ");
            persons.add(new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3])));
        }
        Team team=new Team();
        for (Person person:persons) {
            team.addPlayer(person);
        }
        System.out.println("First team have "+team.getSecondTeam().size()+" players");
        System.out.println("Reserve team have "+team.getFirstTeam().size()+" players");

    }
}
