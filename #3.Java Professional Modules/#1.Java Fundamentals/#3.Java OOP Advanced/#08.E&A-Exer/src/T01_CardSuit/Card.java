package T01_CardSuit;

public enum Card {
    CLUBS(0), DIAMONDS(1), HEARTS(3), SPADES(4);
    private int ordinal;
    Card(int ordinal){
        this.ordinal=ordinal;
    }

    @Override
    public String toString(){
        return String.format("Ordinal value: %d; Name value: %s",ordinal(),name());
    }
}
