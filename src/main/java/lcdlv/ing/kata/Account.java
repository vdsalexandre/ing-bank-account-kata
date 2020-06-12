package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WithdrawException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Account {
    private List<Transaction> transactions = new ArrayList<>();

    public Account() { }

    public Account(Amount amount) {
        this.transactions.add(new Transaction(Transaction.DEPOSIT, amount));
    }

    public void deposit(Amount amount) {
        this.transactions.add(new Transaction(Transaction.DEPOSIT, amount));
    }

    public double getBalance() {
        AtomicReference<Double> balance = new AtomicReference<>((double) 0);
        transactions.forEach(t -> {
                    if (t.getType().equals(Transaction.DEPOSIT))
                        balance.updateAndGet(b -> b + t.getTransactionAmount());
                    else
                        balance.updateAndGet(b -> b - t.getTransactionAmount());
                });
        return balance.get();
    }

    public void withdraw(Amount amount) throws WithdrawException {
        if (amount.getAmount() > getBalance()) throw new WithdrawException("Withdraw error ! You don't have enough in your account");
        this.transactions.add(new Transaction(Transaction.WITHDRAW, amount));
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }
}
