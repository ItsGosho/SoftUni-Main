package T06_Animals;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        while(true){
            String line1=skener.nextLine();
            String line2=skener.nextLine();
            if(line1.equals("Beast!")){
                 break;
            }
            String[] splitted=line2.split(" ");

            String type=line1;
            String name=splitted[0];
            int age=Integer.parseInt(splitted[1]);
            String gender=splitted[2];
            Animal animal=new Animal(type,name,age,gender);
        }
    }
}
