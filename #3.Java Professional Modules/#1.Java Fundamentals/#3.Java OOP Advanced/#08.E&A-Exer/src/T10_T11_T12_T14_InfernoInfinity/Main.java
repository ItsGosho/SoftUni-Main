package T10_T11_T12_T14_InfernoInfinity;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        WeaponController weaponController =new WeaponController();
        while(true){
            String[] line=skener.nextLine().split(";");
            if(line[0].equals("END")){
                break;
            }
            if(line[0].equals("Create")){
                 weaponController.Create(line[1],line[2]);
            }else if(line[0].equals("Add")){
                 weaponController.Add(line[1],Integer.parseInt(line[2]),line[3]);
            }else if(line[0].equals("Remove")){
                weaponController.Remove(line[1],Integer.parseInt(line[2]));
            }else if(line[0].equals("Print")){
                System.out.println(weaponController.Print(line[1]));
            }else if(line[0].equals("Compare")){
                System.out.println(weaponController.Compare(line[1],line[2]));
            }
        }
    }
}
