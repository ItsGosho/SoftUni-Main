package T09_Google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Person {
        public static HashMap<String, Company> personCompany = new HashMap<>();
        public static HashMap<String, List<Pokemon>> personPokemon = new HashMap<>();
        public static HashMap<String, List<Parents>> personParents = new HashMap<>();
        public static HashMap<String, List<Children>> personChildren = new HashMap<>();
        public static HashMap<String, Car> personCar = new HashMap<>();
        public void printInfo(String name){
            System.out.println(name);
            System.out.println("Company:");
            Person.personCompany.entrySet()
                    .stream()
                    .filter(x->x.getKey().equals(name))
                    .forEach(x->{
                        System.out.printf("%s %s %.2f",x.getValue().companyName,x.getValue().department,x.getValue().salary);
                        System.out.println();
                    });
            System.out.println("Car:");
            Person.personCar.entrySet()
                    .stream()
                    .filter(x->x.getKey().equals(name))
                    .forEach(x->{
                        System.out.println(x.getValue().model+" "+x.getValue().speed);
                    });
            System.out.println("Pokemon:");
            Person.personPokemon.entrySet()
                    .stream()
                    .filter(x->x.getKey().equals(name))
                    .forEach(x->{
                        for (int i = 0; i < x.getValue().size(); i++) {
                            System.out.println(x.getValue().get(i).name+" "+x.getValue().get(i).pokemonType);
                        }
                    });
            System.out.println("Parents:");
            Person.personParents.entrySet()
                    .stream()
                    .filter(x->x.getKey().equals(name))
                    .forEach(x->{
                        for (int i = 0; i < x.getValue().size(); i++) {
                            System.out.println(x.getValue().get(i).name+" "+x.getValue().get(i).birthDay);
                        }
                    });
            System.out.println("Children:");
            Person.personChildren.entrySet()
                    .stream()
                    .filter(x->x.getKey().equals(name))
                    .forEach(x->{
                        for (int i = 0; i < x.getValue().size(); i++) {
                            System.out.println(x.getValue().get(i).name+" "+x.getValue().get(i).birthDay);
                        }
                    });

        }
        public void addCompany(String[] line) {
            Company company = new Company(line);
            if(!Person.personCompany.containsKey(line[0])){
                Person.personCompany.put(line[0],company);
            }else{
                Person.personCompany.put(line[0],company);
            }
        }
        public void addPokemon(String[] line) {
            Pokemon pokemon = new Pokemon(line);
            if(!Person.personPokemon.containsKey(line[0])){
                Person.personPokemon.put(line[0],new ArrayList<>());
                Person.personPokemon.get(line[0]).add(pokemon);
            }else{
                Person.personPokemon.get(line[0]).add(pokemon);
            }
        }
        public void addParents(String[] line) {
            Parents parents = new Parents(line);
            if(!Person.personParents.containsKey(line[0])){
                Person.personParents.put(line[0],new ArrayList<>());
                Person.personParents.get(line[0]).add(parents);
            }else{
                Person.personParents.get(line[0]).add(parents);
            }
        }
        public void addChildren(String[] line) {
            Children children = new Children(line);
            if(!Person.personChildren.containsKey(line[0])){
                Person.personChildren.put(line[0],new ArrayList<>());
                Person.personChildren.get(line[0]).add(children);
            }else{
                Person.personChildren.get(line[0]).add(children);
            }
        }
        public void addCar(String[] line) {
            Car car = new Car(line);
            if(!Person.personCar.containsKey(line[0])){
                Person.personCar.put(line[0],car);
            }else{
                Person.personCar.put(line[0],car);
            }
        }
        class Company{
            public String companyName;
            public String department;
            public double salary;

            public Company(String[] line) {
                this.companyName = line[2];
                this.department = line[3];
                this.salary = Double.parseDouble(line[4]);
            }
        }

        class Pokemon {
            public String name;
            public String pokemonType;
            public Pokemon(String[] line){
                this.name=line[2];
                this.pokemonType=line[3];
            }
        }

        class Parents {
            public String name;
            public String birthDay;
            public Parents(String[] line){
                this.name=line[2];
                this.birthDay=line[3];
            }
        }

        class Children {
            public String name;
            public String birthDay;
            public Children(String[] line){
                this.name=line[2];
                this.birthDay=line[3];
            }
        }

        class Car {
            public String model;
            public String speed;
            public Car(String[] line){
                this.model=line[2];
                this.speed=line[3];
            }
        }
    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Person person = new Person();
        while (true) {
            String line = skener.nextLine();
            if (line.equals("End")) {
                break;
            }
            String[] vhod = line.split(" ");
            if (vhod[1].equals("company")) {
                person.addCompany(vhod);
            }else if(vhod[1].equals("pokemon")){
                person.addPokemon(vhod);
            }else if(vhod[1].equals("parents")){
                person.addParents(vhod);
            }else if(vhod[1].equals("children")){
                person.addChildren(vhod);
            }else if(vhod[1].equals("car")){
                person.addCar(vhod);
            }
        }
        String toPrintName=skener.nextLine();
        person.printInfo(toPrintName);
    }
}
