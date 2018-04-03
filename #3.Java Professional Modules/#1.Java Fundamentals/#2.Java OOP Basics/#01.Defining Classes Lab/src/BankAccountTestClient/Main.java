package BankAccountTestClient;

import java.util.Scanner;

public class Main {
    //Gosho------------------------------>
    public static void main(String[] args) {
        Scanner skener = new Scanner(System.in);
        BankAccount bank=new BankAccount();
        while (true) {
            String line = skener.nextLine();
            if (line.equals("End")) {
                break;
            }
            String[] vhod = line.split(" ");
            switch (vhod[0]) {
                case "Create":
                    bank.setId(Integer.parseInt(vhod[1]));
                    break;
                case "Deposit":
                    bank.deposit(Integer.parseInt(vhod[1]), Double.parseDouble(vhod[2]));
                    break;
                case "Withdraw":
                    bank.withdraw(Integer.parseInt(vhod[1]), Double.parseDouble(vhod[2]));
                    break;
                case "Print":
                    try {
                        bank.getBalacnce(Integer.parseInt(vhod[1]));
                    }catch(NullPointerException e) {
                        System.out.println("Account does not exist");
                    }
                    break;
            }
        }
    }
}
