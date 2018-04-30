package T03_CoffeeMachine;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
       CoffeeMachine coffeeMachine=new CoffeeMachine();
        while(true){
            String line=skener.nextLine();
            if(line.equals("END")){
                break;
            }
            String[] splitted=line.split(" ");
             if(splitted.length==1){
                coffeeMachine.insertCoin(splitted[0]);
             }else{
                 coffeeMachine.buyCoffee(splitted[0],splitted[1]);
             }
        }
        for (Coffee coffee : coffeeMachine.coffeesSold()) {
            System.out.println(coffee);
        }
    }
}
