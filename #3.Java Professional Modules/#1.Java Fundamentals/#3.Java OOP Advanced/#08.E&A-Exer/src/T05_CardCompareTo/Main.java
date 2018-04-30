package T05_CardCompareTo;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String nameRank1=skener.nextLine();
        String nameSuit1=skener.nextLine();
        Card card1=new Card(nameRank1,nameSuit1);
        String nameRank2=skener.nextLine();
        String nameSuit2=skener.nextLine();
        Card card2=new Card(nameRank2,nameSuit2);
       if( card1.compareTo(card2.getTotalPower())<0){
           System.out.println(card1.toString());
       }else{
           System.out.println(card2.toString());
       }
    }
}
