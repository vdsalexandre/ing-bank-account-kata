package lcdlv.ing.kata;

public class Account {
    private double balance;

    public void deposit(double amount) {
        this.balance = amount;
    }

    public double getBalance() {
        return balance;
    }
}
