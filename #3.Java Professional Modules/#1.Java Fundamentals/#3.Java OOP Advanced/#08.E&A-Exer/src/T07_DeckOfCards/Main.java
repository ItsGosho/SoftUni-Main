package T07_DeckOfCards;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String line=skener.nextLine();
        for (SuitPowers suitPowers:SuitPowers.values()){
            for(RankPowers rankPowers:RankPowers.values()){
                System.out.println(rankPowers+" of "+suitPowers);
            }
        }
    }
}
