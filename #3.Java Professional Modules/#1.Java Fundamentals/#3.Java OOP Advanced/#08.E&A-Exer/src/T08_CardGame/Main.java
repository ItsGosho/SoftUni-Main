package T08_CardGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Map<String, Card> dict = new HashMap<>();
        Card card1 = new Card();
        Card card2 = new Card();
        String playerName1 = skener.nextLine();
        String playerName2 = skener.nextLine();

        while (card1.getCards().size()!=5) {
            String[] line=skener.nextLine().split(" ");
            try {
                card1.addCard(line[0], line[2]);
            }catch (IllegalArgumentException ex){
                if(ex.getMessage().contains("No enum constant")){
                    System.out.println("No such card exist.");
                }else if(ex.getMessage().contains("No such card")){
                    System.out.println("Card is not in the deck.");
                }
            }
        }
        dict.put(playerName1,card1);
        while (card2.getCards().size()!=5) {
            String[] line=skener.nextLine().split(" ");
            try {
                card2.addCard(line[0], line[2]);
            }catch (IllegalArgumentException ex){
                if(ex.getMessage().contains("No enum constant")){
                    System.out.println("No such card exist.");
                }else if(ex.getMessage().contains("No such card")){
                    System.out.println("Card is not in the deck.");
                }
            }
        }
        dict.put(playerName2,card2);
        if(dict.get(playerName1).getPower()> dict.get(playerName2).getPower()){
            System.out.println(playerName1+" wins with "+dict.get(playerName1).getTheCARD()+".");
        }else{
            System.out.println(playerName2+" wins with "+dict.get(playerName2).getTheCARD()+".");
        }
    }
}
