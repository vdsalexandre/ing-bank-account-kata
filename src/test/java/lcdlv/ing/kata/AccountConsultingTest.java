package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WithdrawException;
import lcdlv.ing.kata.exception.WrongAmountException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountConsultingTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final PrintStream originalOutput = System.out;
    private static final String s = System.lineSeparator();

    // USER STORY 3 :
    // En tant que banque, j'offre la possibilité à mon client de consulter le solde de son compte

    @BeforeEach
    public void initOutStream() {
        System.setOut(new PrintStream(output));
    }

    @AfterAll
    public static void restoreOutStream() {
        System.setOut(originalOutput);
    }

    @Test
    void returns_true_when_client_check_his_empty_account() {
        String expectedConsoleMessage = "Your balance is 0.0 €";
        Account account = new Account();

        System.out.print("Your balance is " + account.getBalance() + " €");

        assertThat(output.toString()).isEqualTo(expectedConsoleMessage);
    }

    @Test
    void returns_true_when_client_check_his_non_empty_account() throws WrongAmountException {
        String expectedConsoleMessage = "Your balance is 15.25 €";
        Account account = new Account(new Amount(15.25));

        System.out.print("Your balance is " + account.getBalance() + " €");

        assertThat(output.toString()).isEqualTo(expectedConsoleMessage);
    }

    @Test
    void returns_true_when_balance_console_message_is_correct_after_some_withdraws_and_deposits() throws WithdrawException, WrongAmountException {
        String expectedConsoleMessage = "Your balance is 35,50 €" + s +
                                        "Your balance is 28,25 €" + s +
                                        "Your balance is 50,00 €" + s +
                                        "Your balance is 12,70 €" + s;

        Account account = new Account(new Amount(35.50));
        System.out.println("Your balance is " + String.format("%.2f", account.getBalance()) + " €");

        account.withdraw(7.25);
        System.out.println("Your balance is " + String.format("%.2f", account.getBalance()) + " €");

        account.deposit(new Amount(21.75));
        System.out.println("Your balance is " + String.format("%.2f", account.getBalance()) + " €");

        account.withdraw(37.30);
        System.out.println("Your balance is " + String.format("%.2f", account.getBalance()) + " €");

        assertThat(output.toString()).isEqualTo(expectedConsoleMessage);
    }
}
