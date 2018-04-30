package T05_CardCompareTo;

public class Card <T> implements Comparable<T>{
    private String nameRank;
    private String nameSuit;
    private int totalPower;

    public Card(String nameRank, String nameSuit) {
        this.nameRank = nameRank;
        this.nameSuit = nameSuit;
        this.setTotalPower();
    }

    public int getTotalPower() {
        return totalPower;
    }

    public int setTotalPower(){
        this.totalPower=RankPowers.valueOf(this.nameRank).getPower()+SuitPowers.valueOf(this.nameSuit).getPower();
        return this.totalPower;
    }

    @Override
    public String toString() {
        return "Card name: "+this.nameRank+" of "+this.nameSuit+"; Card power: "+this.totalPower;
    }

    @Override
    public int compareTo(T vtori) {
        if(this.getTotalPower()<(Integer)vtori){
            return 1;
        }else{
            return -1;
        }
    }
}
