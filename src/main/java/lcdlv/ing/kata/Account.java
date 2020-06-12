package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WithdrawException;
import lcdlv.ing.kata.exception.WrongAmountException;

public class Account {
    private double balance;

    public Account() {
        this.balance = 0;
    }

    public Account(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) throws WrongAmountException {
        if (amount < 0.01) throw new WrongAmountException("Wrong amount ! Amount must be greater or equal to 0.01 €");
        this.balance += amount;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws WithdrawException {
        if (amount > this.balance) throw new WithdrawException("Withdraw error ! You don't have enough in your account");
        this.balance -= amount;
    }
}
