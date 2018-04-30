package T04_CardToString;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String nameRank=skener.nextLine();
        String nameSuit=skener.nextLine();
        Card card=new Card(nameRank,nameSuit);
        System.out.println(card.toString());
    }
}
