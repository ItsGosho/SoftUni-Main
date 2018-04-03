package StaticIDAndInterestRate;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        while (true) {
            String line = skener.nextLine();
            if (line.equals("End")) {
                break;
            }
            String[] vhod = line.split(" ");
            switch (vhod[0]) {
                case "Create":
                    BankAccount bank = new BankAccount();
                    break;
                case "Deposit":
                    BankAccount.deposit(Integer.parseInt(vhod[1]),Double.parseDouble(vhod[2]));
                    break;
                case "SetInterest":
                    BankAccount.setInterestRate(Double.parseDouble(vhod[1]));
                    break;
                case "GetInterest":
                    BankAccount.getInterest(Integer.parseInt(vhod[1]),Integer.parseInt(vhod[2]));
                    break;
            }
        }
    }
}
