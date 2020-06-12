package lcdlv.ing.kata;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class IngKataUserStory3Test {

    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final PrintStream originalOutput = System.out;

    // USER STORY 3 :
    // En tant que banque, j'offre la possibilité à mon client de consulter le solde de son compte

    @BeforeAll
    public static void initOutStream() {
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
}
