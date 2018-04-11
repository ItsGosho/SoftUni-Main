package T04_MordorCrueltyPlan;

import java.util.Scanner;

public class Main {
    public static class Foods{
        private static int totalPoints=0;

        public static int getTotalPoints() {
            return totalPoints;
        }
        public Foods(){
        }
        public Foods(String food){
            this.getFood(food);
        }
        private void getFood(String food){

            switch (food){
                case "cram":
                    totalPoints+=2;
                    break;
                case "lembas":
                    totalPoints+=3;
                    break;
                case "apple":
                    totalPoints+=1;
                    break;
                case "melon":
                    totalPoints+=1;
                    break;
                case "honeycake":
                    totalPoints+=5;
                    break;
                case "mushrooms":
                    totalPoints-=10;
                    break;
                default:
                    totalPoints-=1;
                    break;
            }
        }
        public int getPoints(){
            return Foods.totalPoints;
        }
    }
    public static class Gandalf extends  Foods{
        private String happines;

        public Gandalf(){
            this.setHappines();
        }
        private void setHappines(){
            Foods foods=new Foods();
            if(foods.getPoints()< -5){
                this.happines="Angry";
            }else if(foods.getPoints()>=-5 && foods.getPoints()<0){
                this.happines="Sad";
            }else if(foods.getPoints()>=0 && foods.getPoints()<15){
                this.happines="Happy";
            }else if(foods.getPoints()>=15){
                this.happines="JavaScript";
            }
        }
        @Override
        public String toString(){
            return String.format("%s\n%s",Foods.getTotalPoints(),this.happines);
        }
    }
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        String[] vhod=skener.nextLine().split(" ");
        for (int i = 0; i < vhod.length; i++) {
            Foods foods=new Foods(vhod[i].toLowerCase());
        }
        Gandalf gandalf=new Gandalf();
        System.out.println(gandalf.toString());
    }
}
