package T08_CardGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Card {
    private String nameRank;
    private String nameSuit;
    private String theCARD;
    private int power;

    public String getTheCARD() {
        return theCARD;
    }

    private List<String> cards;

    public int getPower() {
        return power;
    }

    public List<String> getCards() {
        return cards;
    }

    public Card() {
        this.cards = new ArrayList<>();
    }

    public void addCard(String rank, String suit) {
       check(rank, suit);
            if (!this.cards.contains(rank + " of " + suit)) {
                this.nameRank = rank;
                this.nameSuit = suit;
                this.cards.add(this.nameRank + " of " + this.nameSuit);
                if(this.setTotalPower()){
                    this.theCARD=this.nameRank + " of " + this.nameSuit;
                }
            } else {
                throw new IllegalArgumentException("No such card");
            }
    }

    public boolean setTotalPower() {
        int currSum = this.power;
        int newSUm =RankPowers.valueOf(this.nameRank).getPower() + SuitPowers.valueOf(this.nameSuit).getPower();
        if (currSum<newSUm) {
            this.power=newSUm;
            return true;
        }
        return false;
    }
    public void check(String rank, String suit){
        RankPowers.valueOf(rank);
        SuitPowers.valueOf(suit);
    }

    @Override
    public String toString() {
        return "Card name: " + nameRank + " of " + nameSuit + "; Card power: " + power;
    }
}
