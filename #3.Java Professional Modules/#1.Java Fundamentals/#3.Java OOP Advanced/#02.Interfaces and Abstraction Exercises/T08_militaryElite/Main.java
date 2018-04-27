package T08_militaryElite;

import T08_militaryElite.Interfaces.iLeutenantGeneral;
import T08_militaryElite.Interfaces.iPrivate;
import T08_militaryElite.Interfaces.iSoldier;
import T08_militaryElite.Models.LeutenantGeneral;
import T08_militaryElite.Models.Private;

import java.util.*;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Map<String, iSoldier> privateById = new HashMap<>();
        List<iLeutenantGeneral> leutenantGenerals=new ArrayList<>();
        while(true){
            String line=skener.nextLine();
            if(line.equals("End")){
                break;
            }
            String[] vhod=line.split(" ");
            if(vhod[0].equals("Private")){
                iPrivate _private=new Private(vhod[1],vhod[2],vhod[3],Double.parseDouble(vhod[4]));
                privateById.put(vhod[1],_private);
            }else if(vhod[0].equals("LeutenantGeneral")){
                String id=vhod[1];
                String firstName=vhod[2];
                String lastName=vhod[3];
                double salarty=Double.parseDouble(vhod[4]);
                iLeutenantGeneral leutenantGeneral=new LeutenantGeneral(id,firstName,lastName,salarty);
                for (int i = 4; i < vhod.length; i++) {
                    String nowId=vhod[i];
                    Private _private= (Private) privateById.get(nowId);
                    if(_private!=null) {
                        ((LeutenantGeneral) leutenantGeneral).addPrivate(_private);
                    }
                }
                leutenantGenerals.add(leutenantGeneral);
            }
        }
        privateById.entrySet().stream()
                .forEach(x->{
                    System.out.println(x.getValue().toString());
                });
    }
}
