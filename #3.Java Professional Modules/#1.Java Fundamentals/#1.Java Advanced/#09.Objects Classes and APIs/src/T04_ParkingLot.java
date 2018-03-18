import java.util.HashSet;
import java.util.Scanner;

public class T04_ParkingLot {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        HashSet<String> list=new HashSet<>();
        while (true) {
            String line = skener.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] splitted=line.split(", ");
            if(splitted[0].equals("IN")){
              list.add(splitted[1]);
            }else{
                list.remove(splitted[1]);
            }
        }
        if(!list.isEmpty()) {
            for (String item : list) {
                System.out.println(item);
            }
        }else{
            System.out.println("Parking Lot is Empty");
        }
    }
}
