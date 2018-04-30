package T04_CardToString;

public class Card {
    private String nameRank;
    private String nameSuit;
    private int totalPower;

    public Card(String nameRank, String nameSuit) {
        this.nameRank = nameRank;
        this.nameSuit = nameSuit;
        this.setTotalPower();
    }
    public int setTotalPower(){
        this.totalPower=RankPowers.valueOf(this.nameRank).getPower()+SuitPowers.valueOf(this.nameSuit).getPower();
        return this.totalPower;
    }

    @Override
    public String toString() {
        return "Card name: "+nameRank+" of "+nameSuit+"; Card power: "+totalPower;
    }
}
