package T03_Hierarchical_Inheritance;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Dog dog=new Dog();
        dog.eat();
        dog.bark();
        Cat cat=new Cat();
        cat.eat();
        cat.meow();
    }
}
