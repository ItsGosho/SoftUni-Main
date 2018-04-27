package T11_Threeuple;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String[] line=new String[3];
            if(i==0){
                String[] asd=skener.nextLine().split(" ");
                line[0]=asd[0]+" "+asd[1];
                line[1]=asd[2];
                line[2]=asd[3];
            }else{
                String[] asd=skener.nextLine().split(" ");
                line[0]=asd[0];
                line[1]=asd[1];
                line[2]=asd[2];
            }
            iTuple tuple=new Tuple(line[0],line[1],line[2]);
            System.out.println(tuple.toString());
        }
     }
}
