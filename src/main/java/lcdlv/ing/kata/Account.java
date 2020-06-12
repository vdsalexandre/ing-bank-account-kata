package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WithdrawException;
import lcdlv.ing.kata.exception.WrongAmountException;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private static final double MIN_AMOUNT = 0.01;
    private double balance;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
        this.balance = 0;
    }

    public Account(double balance) {
        this.balance = balance;
        this.transactions.add(new Transaction(Transaction.DEPOSIT, balance));
    }

    public void deposit(double amount) throws WrongAmountException {
        if (amount < MIN_AMOUNT) throw new WrongAmountException("Wrong amount ! Amount must be greater or equal to 0.01 €");
        this.balance += amount;
        this.transactions.add(new Transaction(Transaction.DEPOSIT, amount));
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) throws WithdrawException {
        if (amount > this.balance || amount < MIN_AMOUNT) throw new WithdrawException("Withdraw error ! You don't have enough in your account");
        this.balance -= amount;
        this.transactions.add(new Transaction(Transaction.WITHDRAW, amount));
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }
}
