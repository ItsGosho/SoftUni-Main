package T02_CardRank;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        System.out.println(skener.nextLine()+":");
        for (Card card : Card.values()) {
            System.out.println(card);
        }
    }
}
