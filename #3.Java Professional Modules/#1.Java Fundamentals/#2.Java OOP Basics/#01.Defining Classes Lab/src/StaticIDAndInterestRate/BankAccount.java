package StaticIDAndInterestRate;

import java.util.HashMap;

public class BankAccount {
    private static int id = 0;
    private static double balance;
    private static double interestRate = 0.02;
    private static HashMap<Integer, Double> user = new HashMap<>();

    BankAccount() {
        BankAccount.id++;
        System.out.println("Account ID" + BankAccount.id + " created");
        BankAccount.user.put(BankAccount.id,0.00);
    }

    public static void setInterestRate(double interest) {
        BankAccount.interestRate = interest;
    }

    public static void getInterest(int id,int years) {
        BankAccount.id=id;
        if(!BankAccount.user.containsKey(BankAccount.id)){
            System.out.println("Account does not exist");
        }else {
            System.out.printf("%.2f",BankAccount.interestRate * (double)years * BankAccount.user.get(BankAccount.id));
            System.out.println();
        }
    }

    public static void deposit(int id,double amount) {
        BankAccount.id=id;
        if(BankAccount.user.containsKey(BankAccount.id)) {
            BankAccount.balance = user.get(BankAccount.id) + amount;
            BankAccount.user.put(BankAccount.id, BankAccount.balance);
            System.out.printf("Deposited %.0f to ID%d",BankAccount.balance,BankAccount.id);
            System.out.println();
        }else{
            System.out.println("Account does not exist");
        }
    }
}
