package T04_ShoppingSpree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static class Person {
        private String name;
        private int money;
        private static LinkedHashMap<String, List<String>> personProducts = new LinkedHashMap<>();
        private static LinkedHashMap<String, Integer> personInfo = new LinkedHashMap<>();

        public void addPerson(String name, int money) {
            this.setName(name);
            this.setMoney(money);
            Person.personInfo.put(this.name, this.money);
        }

        private String setName(String name) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            } else {
                return this.name = name;
            }
        }

        private int setMoney(int money) {
            if (money < 0) {
                throw new IllegalArgumentException("Money cannot be negative");
            } else {
                return this.money = money;
            }
        }

        public void addProduct(String personName, String productName) {
            Product product = new Product();
            if (Product.products.get(productName) <= Person.personInfo.get(personName)) {
                System.out.printf("%s bought %s\n", personName, productName);
                personProducts.putIfAbsent(personName, new ArrayList<>());
                personProducts.get(personName).add(productName);
                personInfo.put(personName, personInfo.get(personName) - Product.products.get(productName));
            } else {
                personProducts.putIfAbsent(personName, new ArrayList<>());
                System.out.printf("%s can't afford %s\n", personName, productName);
            }
        }

        public void getAllProducts() {
            personProducts.entrySet().stream().forEach(x -> {
                if (x.getValue().size() == 0) {
                    System.out.println(x.getKey() + " - Nothing bought\n");
                } else {
                    System.out.print(x.getKey() + " - ");
                    String toObrabotq = "";
                    for (int i = 0; i < x.getValue().size(); i++) {
                        toObrabotq += x.getValue().get(i) + ", ";
                    }
                    StringBuilder str = new StringBuilder(toObrabotq);
                    str.replace(str.length() - 2, str.length(), "");
                    System.out.print(str.toString());
                    System.out.println();
                }
            });
        }
    }
    public static class Product {
        private String name;
        private int cost;
        public static LinkedHashMap<String,Integer> products=new LinkedHashMap<>();

        public void addProduct(String name,int cost){
            this.setName(name);
            this.setCost(cost);
            products.put(this.name,this.cost);
        }
        private String setName(String name){
            return this.name=name;
        }
        private void setCost(int cost) {
            this.cost = cost;
        }
    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] personsAndMoney = skener.nextLine().split(";");
        Person person=new Person();
        Product product=new Product();
        for (int i = 0; i < personsAndMoney.length; i++) {
            String[] splitted = personsAndMoney[i].split("=");
            try {
                person.addPerson(splitted[0], Integer.parseInt(splitted[1]));
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                return;
            }
        }
        String[] productsAndCost = skener.nextLine().split(";");
        for (int i = 0; i < productsAndCost.length; i++) {
            String[] splitted = productsAndCost[i].split("=");
            product.addProduct(splitted[0],Integer.parseInt(splitted[1]));
        }
        while (true) {
            String line = skener.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] vhod=line.split(" ");
            String inputPerson=vhod[0];
            String inputProduct=vhod[1];
            person.addProduct(inputPerson,inputProduct);
        }
        person.getAllProducts();
    }
}
