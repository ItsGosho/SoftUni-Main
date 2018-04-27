package T06_birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        List<Indentify> db=new ArrayList<>();
        while(true){
            String line=skener.nextLine();
            if(line.equals("End")){
                break;
            }
            String[] vhod=line.split(" ");
            if(vhod[0].equals("Citizen")){
                String name=vhod[1];
                String age=vhod[2];
                String id=vhod[3];
                String birthday=vhod[4];
                db.add(new Human(name,age,id,birthday));
            }else if(vhod[0].equals("Robot")){
                String model=vhod[1];
                String id=vhod[2];
                db.add(new Robot(model,id));
            }else if(vhod[0].equals("Pet")){
                String name=vhod[1];
                String birthday=vhod[2];
                db.add(new Pet(name,birthday));
            }
        }
        String birthdayContains=skener.nextLine();
        db.stream().filter(x->x.getBirthDay().endsWith(birthdayContains) && x.getBirthDay()!=null)
                .forEach(x-> System.out.println(x.getBirthDay()));
    }
}
