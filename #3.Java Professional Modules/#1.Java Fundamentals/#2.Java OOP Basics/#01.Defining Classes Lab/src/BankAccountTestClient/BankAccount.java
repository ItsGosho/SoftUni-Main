package BankAccountTestClient;

import java.util.HashMap;

public class BankAccount {
    private int id;
    private double balance;
    private HashMap<Integer, Double> customers = new HashMap<>();

    public void setId(int id) {
        this.id = id;
        if (!this.customers.containsKey(this.id)) {
            this.customers.put(this.id, 0d);
        } else {
            errorAlreadyExist();
        }
    }

    public double getBalacnce(int id) {
        this.id = id;
        return this.balance = this.customers.get(this.id);
    }

    public void deposit(int id, Double amount) {
        this.id = id;
        if (this.customers.containsKey(this.id)) {
            this.customers.put(this.id, this.customers.get(this.id) + amount);
        } else {
            errorNonExist();
        }
    }

    public void withdraw(int id, Double amount) {
        this.id = id;
        if (!this.customers.containsKey(this.id)) {
            errorNonExist();
        } else if (amount > this.customers.get(this.id)) {
            errorNoBalance();
        } else if (this.customers.containsKey(this.id)) {
            this.customers.put(this.id, this.customers.get(this.id) - amount);
        }
    }

    //print command
    private void printAccount() {
        System.out.printf("Account ID%s, balance %.2f", this.id, this.balance);
        System.out.println();
    }

    //errors message
    private void errorAlreadyExist() {
        System.out.println("Account already exists");
    }

    private void errorNonExist() {
        System.out.println("Account does not exist");
    }

    private void errorNoBalance() {
        System.out.println("Insufficient balance");
    }
}
