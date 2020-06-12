package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WithdrawException;
import lcdlv.ing.kata.exception.WrongAmountException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lcdlv.ing.kata.TransactionType.DEPOSIT;
import static lcdlv.ing.kata.TransactionType.WITHDRAW;
import static org.assertj.core.api.Assertions.assertThat;

public class TransactionHistoryTest {

    // USER STORY 4 :
    // En tant que banque, j'offre la possibilité à mon client de consulter
    // l'historique des transactions sur son compte

    @Test
    void returns_true_when_transaction_history_is_equal_to_expected_transaction_history() throws WithdrawException, WrongAmountException {
        List<Transaction> expectedHistory = Arrays.asList(
                new Transaction(DEPOSIT, new Amount(100.00)),
                new Transaction(WITHDRAW, new Amount(25.00)),
                new Transaction(WITHDRAW, new Amount(11.00)),
                new Transaction(DEPOSIT, new Amount(125.50))
        );

        Account account = new Account(new Amount(100.00));
        account.withdraw(new Amount(25.00));
        account.withdraw(new Amount(11.00));
        account.deposit(new Amount(125.50));

        List<Transaction> transactionHistory = account.getTransactionHistory();

        assertThat(transactionHistory).isEqualTo(expectedHistory);
    }
}
