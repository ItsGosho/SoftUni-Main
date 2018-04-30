package T03_CarsWithPower;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String nameRank=skener.nextLine();
        String nameSuit=skener.nextLine();
        int totalPower=RankPowers.valueOf(nameRank).getPower()+SuitPowers.valueOf(nameSuit).getPower();
        System.out.println("Card name: "+nameRank+" of "+nameSuit+"; Card power: "+totalPower);
    }
}
