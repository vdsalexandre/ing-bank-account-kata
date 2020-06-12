package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WrongAmountException;

public class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public void deposit(double amount) throws WrongAmountException {
        if (amount < 0.1) throw new WrongAmountException("Wrong amount ! Amount must be greater or equals than 0.1 €");
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
