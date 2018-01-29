import java.util.Scanner;

public class T04_FruitOrVegetable {
    //Gosho--------------------->
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String something=scanner.nextLine();

        if (something.equals("banana")||something.equals("apple")||something.equals("kiwi")||something.equals("cherry")||something.equals("lemon")||something.equals("grapes")){
            System.out.printf("fruit");
        }
        else if (something.equals("tomato")||something.equals("cucumber")||something.equals("pepper")||something.equals("carrot")){
            System.out.printf("vegetable");
        }
        else {
            System.out.printf("unknown");
        }
    }
}
