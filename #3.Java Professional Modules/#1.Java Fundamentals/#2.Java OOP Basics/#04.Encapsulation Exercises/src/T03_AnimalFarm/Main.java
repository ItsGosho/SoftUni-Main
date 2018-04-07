package T03_AnimalFarm;

import java.util.Scanner;

public class Main {
    public static class Chicken {
        private String name;
        private int age;

        public Chicken(String name,int age){
            this.setName(name);
            this.setAge(age);
        }
        private void setName(String name){
            if(name.equals(null) || name.length()<=0 || name.isEmpty() || name.contains(" ")){
                throw new IllegalArgumentException("Name cannot be empty.");
            }else{
                this.name=name;
            }
        }
        private void setAge(int age){
            if(age>=0 && age<=15){
                this.age=age;
            }else{
                throw new IllegalArgumentException("Age should be between 0 and 15.");
            }
        }
        private int getAge(){
            return this.age;
        }
        private String getName(){
            return this.name;
        }
        public void productionPerDay(){
            this.getProductionPerDay(getAge());
        }
        private void getProductionPerDay(int age){
            if(this.getAge()<6){
                System.out.printf("Chicken %s (age %d) can produce 2 eggs per day.\n",getName(),getAge());
            }else if(this.getAge()>=6 && this.getAge() <=11){
                System.out.printf("Chicken %s (age %d) can produce 1 eggs per day.\n",getName(),getAge());
            }else{
                System.out.printf("Chicken %s (age %d) can produce 0.75 eggs per day.\n",getName(),getAge());
            }
        }
    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String name=skener.nextLine();
        int age=Integer.parseInt(skener.nextLine());
        try{
            Chicken chicken=new Chicken(name,age);
            chicken.productionPerDay();
        }catch (IllegalArgumentException ex){
            System.out.println(ex.getMessage());
        }
    }
}
