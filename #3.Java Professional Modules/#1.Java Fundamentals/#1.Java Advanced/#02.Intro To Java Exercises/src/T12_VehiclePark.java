import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class T12_VehiclePark {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String[] avaliableSellingCars = skener.nextLine().split(" ");
        int sold=0;
        while (true) {
            String line = skener.nextLine();
            if (line.equals("End of customers!")) {
                break;
            }
            String[] vhod = line.split(" ");
            char[] typeWantParse=vhod[0].toCharArray();
            String vehicle=String.valueOf(typeWantParse[0]).toLowerCase();
            String seats=vhod[2];
            String check=vehicle+seats;
            boolean found=false;
            //Проверка за наличност:
            for (int i = 0; i < avaliableSellingCars.length; i++) {
                 if(check.equals(avaliableSellingCars[i])){
                   int soldFor=0;
                   char[] avaliableToChar=avaliableSellingCars[i].toCharArray();
                   char vehicleType=avaliableToChar[0];
                   char[] seatsBroi= Arrays.copyOfRange(avaliableToChar,1,avaliableToChar.length);
                   String umnojeno1="";
                   for (int j = 0; j < seatsBroi.length; j++) {
                         umnojeno1+=seatsBroi[j];
                     }
                     int umnojeno=Integer.parseInt(umnojeno1);
                   soldFor+=vehicleType*umnojeno;
                     System.out.printf("Yes, sold for %d$",soldFor);
                     sold++;
                     avaliableSellingCars[i]="goodbye";
                     found=true;
                     System.out.println();
                     break;
                 }
            }
            if(found==false){
                System.out.println("No");
            }
        }
         //filter
        List<String> leftVehicles=new ArrayList<>();
        for(String left:avaliableSellingCars){
            if(!left.equals("goodbye")){
                leftVehicles.add(left);
            }
        }
        System.out.println("Vehicles left: "+String.join(", ",leftVehicles));
        System.out.println("Vehicles sold: "+sold);
    }
}
