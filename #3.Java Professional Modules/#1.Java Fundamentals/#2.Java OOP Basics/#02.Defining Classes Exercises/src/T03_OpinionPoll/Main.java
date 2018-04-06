package T03_OpinionPoll;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static class Person {
        private String name;
        private int age;
        private HashMap<String,Integer> person=new HashMap<>();

        public void addPerson(String name,int age){
            this.person.put(name,age);
        }
        public String getName(){
            return this.name;
        }
        public int getAge(){
            return this.age;
        }

        public void printPersons() {
            person.entrySet().stream().filter(x->x.getValue()>30)
                    .sorted((x1,x2)->x1.getKey().compareTo(x2.getKey()))
                    .forEach(x-> System.out.println(x.getKey()+" - "+x.getValue()));
        }
    }

    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Person person=new Person();
        int n=Integer.parseInt(skener.nextLine());
        for (int i = 0; i < n; i++) {
            String[] line=skener.nextLine().split(" ");
            person.addPerson(line[0],Integer.parseInt(line[1]));
        }
        person.printPersons();
    }
}