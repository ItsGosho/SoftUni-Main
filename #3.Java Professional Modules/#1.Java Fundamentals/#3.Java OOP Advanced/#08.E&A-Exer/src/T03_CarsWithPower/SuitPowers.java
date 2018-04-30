package T03_CarsWithPower;

public enum SuitPowers {
    CLUBS(0), DIAMONDS(13), HEARTS(26), SPADES(39);
    private int power;
    SuitPowers(int power){
        this.power=power;
    }

    public int getPower() {
        return power;
    }
}
