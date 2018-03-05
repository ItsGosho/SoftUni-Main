import java.util.Scanner;

public class T05_TransportPrice {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        int km=Integer.parseInt(skener.nextLine());
        String time=skener.nextLine();
        double result=0;
        if(km<20){
           if(time.equals("day")){
               result=(km*0.79)+0.70;
           }else if(time.equals("night")){
               result=(km*0.90)+0.70;
           }
        }else if(km>=20 && km<100){
                result=km*0.09;
        }else if(km>=100){
            result=km*0.06;
        }
        System.out.printf("%.2f",result);
    }
}
