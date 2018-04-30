package T03_CoffeeMachine;

public enum Coin {
    ONE(1),TWO(2),FIVE(5),TEN(10),TWENTY(20),FIFTY(50);
    private int money;
    Coin(int money){
        this.money=money;
    }
    public int getMoney(){
        return this.money;
    }
}
