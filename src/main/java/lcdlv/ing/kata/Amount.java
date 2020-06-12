package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WrongAmountException;

import java.util.Objects;

public class Amount {
    private static final double MIN_AMOUNT = 0.01;
    private double amount;

    public Amount(double amount) throws WrongAmountException {
        if (amount < MIN_AMOUNT) throw new WrongAmountException("Wrong amount ! Amount must be greater or equal to 0.01 €");
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
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
