package T09_TrafficLights;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);

        String[] startingSignals=skener.nextLine().split(" ");
        int n=Integer.parseInt(skener.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < Light.values().length; j++) {
                Light nextSignal=null;
                 if(Light.valueOf(startingSignals[j]).ordinal+1==3){
                     nextSignal=Light.values()[0];
                 }else{
                    nextSignal=Light.values()[Light.valueOf(startingSignals[j]).ordinal+1];
                 }
                 startingSignals[j]=nextSignal.name();
                System.out.print(nextSignal.name()+" ");
            }
            System.out.println();
        }
    }
}
