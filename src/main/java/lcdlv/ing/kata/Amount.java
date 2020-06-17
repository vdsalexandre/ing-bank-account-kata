package lcdlv.ing.kata;

import java.util.Objects;

public class Amount {
    private double amount;

    public Amount() {
        this.amount = 0.0;
    }

    public Amount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isBiggerThan(double value) {
        return amount > value;
    }

    public boolean isSmallerThan(double value) {
        return amount < value;
    }

    public void add(Amount amount) {
        this.amount += amount.getAmount();
    }

    public void sub(Amount amount) {
        this.amount -= amount.getAmount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount1 = (Amount) o;
        return Double.compare(amount1.amount, amount) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }
}
