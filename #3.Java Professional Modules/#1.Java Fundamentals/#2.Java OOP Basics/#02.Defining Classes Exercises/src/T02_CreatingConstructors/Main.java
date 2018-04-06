package T02_CreatingConstructors;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static class Person {
        private String name;
        private int age;

        public Person() {
            System.out.println("No name 1");
        }

        public Person(int age) {
            this.age = age;
            System.out.println("No name " + this.age);
        }

        public Person(String name, int age) {
            this.age = age;
            this.name = name;
            System.out.printf("%s %d", this.name, this.age);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String name = skener.nextLine();
        int age = Integer.parseInt(skener.nextLine());
        Person person=new Person();
        Person person1=new Person(age);
        Person person2=new Person(name,age);
    }
}
