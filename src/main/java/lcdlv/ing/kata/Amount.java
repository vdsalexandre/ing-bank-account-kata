package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WrongAmountException;

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
}
