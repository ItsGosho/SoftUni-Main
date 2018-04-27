package T05_borderControl;

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
            if(vhod.length==3){
                String name=vhod[0];
                String age=vhod[1];
                String id=vhod[2];
                db.add(new Human(name,age,id));
            }else{
                String model=vhod[0];
                String id=vhod[1];
                db.add(new Robot(model,id));
            }
        }
        String endsWith=skener.nextLine();
        db.stream().filter(x->x.getId().endsWith(endsWith))
                .forEach(x-> System.out.println(x.getId()));
    }
}
