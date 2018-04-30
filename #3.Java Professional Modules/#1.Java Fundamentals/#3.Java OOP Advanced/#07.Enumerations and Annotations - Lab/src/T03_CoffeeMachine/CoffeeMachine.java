package T03_CoffeeMachine;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine {

    private List<Coffee> coffesBought;
    private int coins;
    public CoffeeMachine(){
        this.coffesBought=new ArrayList<>();
        this.coins=0;
    }
    public void buyCoffee(String size, String type) {

       if(this.coins>=CoffeeSize.valueOf(size.toUpperCase()).getPrice()){
           Coffee coffee=new Coffee(size,type);
           coffesBought.add(coffee);
           this.coins=0;
       }
    }

    public void insertCoin(String coin) {
        this.coins+=Coin.valueOf(coin).getMoney();
    }

    public Iterable<Coffee> coffeesSold() {
         return this.coffesBought;
    }
}
