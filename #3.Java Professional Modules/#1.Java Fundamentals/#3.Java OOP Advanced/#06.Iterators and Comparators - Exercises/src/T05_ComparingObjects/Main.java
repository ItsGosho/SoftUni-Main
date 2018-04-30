package T05_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        List<Person> person=new ArrayList<>();

        while(true){
            String line=skener.nextLine();
            if(line.equals("END")){
                break;
            }
            String[] splitted=line.split(" ");
            person.add(new Person(splitted[0],Integer.parseInt(splitted[1]),splitted[2]));
            for (int i = 0; i < person.size(); i++) {
                person.get(i).getName().compareTo()
            }
        }
    }
}
