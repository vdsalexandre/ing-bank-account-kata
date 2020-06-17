package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WrongAmountException;

import java.util.ArrayList;
import java.util.List;

import static lcdlv.ing.kata.TransactionType.DEPOSIT;
import static lcdlv.ing.kata.TransactionType.WITHDRAW;

public class Account {
    private List<Transaction> transactions = new ArrayList<>();

    public Account() { }

    public Account(Amount amount) {
        this.transactions.add(new Transaction(DEPOSIT, amount));
    }

    public void deposit(Amount amount) throws WrongAmountException {
        if (amount.isSmallerThan(0.01)) throw new WrongAmountException("Wrong amount ! Amount must be greater or equal to 0.01 €");
        this.transactions.add(new Transaction(DEPOSIT, amount));
    }

    public double getBalance() {
        Amount balance = new Amount();
        transactions.forEach(t -> {
            if (t.getType().equals(DEPOSIT))
                balance.add(t.getAmount());
            else
                balance.sub(t.getAmount());
        });
        return balance.getAmount();
    }

    public void withdraw(Amount amount) throws WrongAmountException {
        if (amount.isBiggerThan(getBalance()) || amount.isSmallerThan(0.01)) throw new WrongAmountException("Wrong amount ! You don't have enough in your account");
        this.transactions.add(new Transaction(WITHDRAW, amount));
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }
}
