package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WithdrawException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Account {
    private static final double MIN_AMOUNT = 0.01;
    private List<Transaction> transactions = new ArrayList<>();

    public Account() { }

    public Account(double balance) {
        this.transactions.add(new Transaction(Transaction.DEPOSIT, balance));
    }

    public void deposit(Amount amount) {
//        if (amount.getAmount() < MIN_AMOUNT) throw new WrongAmountException("Wrong amount ! Amount must be greater or equal to 0.01 €");
        this.transactions.add(new Transaction(Transaction.DEPOSIT, amount.getAmount()));
    }

    public double getBalance() {
        AtomicReference<Double> balance = new AtomicReference<>((double) 0);
        transactions.forEach(t -> {
                    if (t.getType().equals(Transaction.DEPOSIT))
                        balance.updateAndGet(b -> b + t.getAmount());
                    else
                        balance.updateAndGet(b -> b - t.getAmount());
                });
        return balance.get();
    }

    public void withdraw(double amount) throws WithdrawException {
        if (amount > getBalance() || amount < MIN_AMOUNT) throw new WithdrawException("Withdraw error ! You don't have enough in your account");
        this.transactions.add(new Transaction(Transaction.WITHDRAW, amount));
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }
}
