package lcdlv.ing.kata;

import java.util.Objects;

public class Transaction {
    public static final String DEPOSIT = "deposit";
    public static final String WITHDRAW = "withdraw";

    private String type;
    private Amount amount;

    public Transaction(String type, Amount amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getTransactionAmount() {
        return amount.getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return type.equals(that.type) &&
                Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, amount);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}
