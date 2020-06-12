package lcdlv.ing.kata.exception;

public class WrongAmountException extends Exception {
    public WrongAmountException() {
        super();
    }

    public WrongAmountException(String message) {
        super(message);
    }
}
