package T04_telephony;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        Technologies technologies = new Technologies();
        String[] number = skener.nextLine().split(" ");
        for (int i = 0; i < number.length; i++) {
            technologies.callingTo(number[i]);
        }
        String[] URLS=skener.nextLine().split(" ");
        for (int i = 0; i < URLS.length; i++) {
            technologies.browsingIn(URLS[i]);
        }
    }
}
