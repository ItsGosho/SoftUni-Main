package T05_PizzaCalories;

import java.util.Scanner;

class Main {
    public static class Pizza {
        private String pizzaName;
        private String dough;
        private String toppings;
        private int numberOfModifiers;
        private double totalCaolories;

        public Pizza(String name,int numberOfModifiers){
            this.setPizzaName(name);
            this.setNumberOfModifiers(numberOfModifiers);
        }
        private String setPizzaName(String pizzaName) {
            if (pizzaName.length() >= 1 && pizzaName.length() <= 15) {
                return this.pizzaName = pizzaName;
            } else {
                throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
            }
        }
        private int setNumberOfModifiers(int numberOfModifiers){
            if(numberOfModifiers>=0 && numberOfModifiers<=10){
                return this.numberOfModifiers=numberOfModifiers;
            }else{
                throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
            }
        }
    }
    public static class Dough {
        private String flourType;
        private String bakingTechnique;
        private double doughtWeight;
        public static double totalCalories=0;

        public Dough(String flourType, String bakingTechnique, double doughtWeight) {
            this.setType(flourType);
            this.setBakingTechnique(bakingTechnique);
            this.setDoughtWeight(doughtWeight);
            this.calculateDought();
        }

        private String setType(String flourType){
            if(flourType.equals("White") || flourType.equals("Wholegrain")){
                return this.flourType=flourType;
            }else{
                throw new IllegalArgumentException("Invalid type of dough.");
            }
        }
        private String setBakingTechnique(String bakingTechnique){
            if(bakingTechnique.equals("Crispy") ||
                    bakingTechnique.equals("Chewy") ||
                    bakingTechnique.equals("Homemade")){
                return this.bakingTechnique=bakingTechnique;
            }else{
                throw new IllegalArgumentException("Invalid type of dough.");
            }
        }
        private Double setDoughtWeight(double doughtWeight){
            if(doughtWeight>=1 && doughtWeight<=200){
                return this.doughtWeight=doughtWeight;
            }else{
                throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
            }
        }

        private double calculateDought(){
            double forNow=0;
            forNow+=this.doughtWeight;
            switch (this.flourType){
                case "White":
                    forNow*=1.5;
                    break;
                case "Wholegrain":
                    forNow*=1.0;
                    break;
            }
            switch (this.bakingTechnique){
                case "Crispy":
                    forNow*=0.9;
                    break;
                case "Chewy":
                    forNow*=1.1;
                    break;
                case "Homemade":
                    forNow*=1.0;
                    break;
            }
            return totalCalories+=forNow;
        }
    }
    public static class Toppings {
        private String toppingType;
        private double toppingWeight;
        public static double totalCalories=0;
        public void addToping(String toppingType,Double toppingWeight){
            this.setToppingType(toppingType);
            this.setToppingWeight(toppingWeight);
            this.calculateCurrentCalories();
        }
        private String setToppingType(String toppingType){
            if(toppingType.equals("Meat") ||
                    toppingType.equals("Veggies") ||
                    toppingType.equals("Cheese") ||
                    toppingType.equals("Sauce")){
                return this.toppingType=toppingType;
            }else{
                throw new IllegalArgumentException("Cannot place "+toppingType+" on top of your pizza.");
            }
        }
        private Double setToppingWeight(double toppingWeight){
            if(toppingWeight>=1 && toppingWeight<=50){
                return this.toppingWeight=toppingWeight;
            }else{
                throw new IllegalArgumentException(toppingWeight+" weight should be in the range [1..50].");
            }
        }
        private double calculateCurrentCalories(){
            double forNow=0;
            forNow+=this.toppingWeight;
            switch (this.toppingType){
                case "Meat":
                    forNow*=1.2;
                    break;
                case "Veggies":
                    forNow*=0.8;
                    break;
                case "Cheese":
                    forNow*=1.1;
                    break;
                case "Sauce":
                    forNow*=0.9;
                    break;
            }
            return totalCalories+=forNow;
        }
    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String[] firstLine=skener.nextLine().split(" ");
        String pizzaName=firstLine[1];
        int numberOfTopings=Integer.parseInt(firstLine[2]);
        try {
            Pizza pizza = new Pizza(pizzaName, numberOfTopings);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }
        String[] doughProperties=skener.nextLine().split(" ");
        String type=doughProperties[1];
        String bakingTechnique=doughProperties[2];
        double weightInGrams=Double.parseDouble(doughProperties[3]);
        try {
            Dough dough = new Dough(type, bakingTechnique, weightInGrams);
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
            return;
        }
        Toppings toppings=new Toppings();
        for (int i = 0; i < numberOfTopings; i++) {
            String[] topingProperties=skener.nextLine().split(" ");
            if(topingProperties.equals("END")){
                break;
            }
            String topingType=topingProperties[1];
            double topingWeightInGrams=Double.parseDouble(topingProperties[2]);
            try {
                toppings.addToping(topingType, topingWeightInGrams);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                return;
            }
        }
        System.out.printf("%s - %.2f",pizzaName,(Dough.totalCalories+Toppings.totalCalories)*2);
    }
}
