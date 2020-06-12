package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WithdrawException;
import lcdlv.ing.kata.exception.WrongAmountException;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TransactionHistoryTest {

    // USER STORY 4 :
    // En tant que banque, j'offre la possibilité à mon client de consulter
    // l'historique des transactions sur son compte

    @Test
    void returns_true_when_transaction_history_is_equal_to_expected_transaction_history() throws WithdrawException, WrongAmountException {
        List<Transaction> expectedHistory = Arrays.asList(
                new Transaction(Transaction.DEPOSIT, 100.00),
                new Transaction(Transaction.WITHDRAW, 25.00),
                new Transaction(Transaction.WITHDRAW, 11.00),
                new Transaction(Transaction.DEPOSIT, 125.50)
        );

        Account account = new Account(100.00);
        account.withdraw(25.00);
        account.withdraw(11.00);
        account.deposit(125.50);

        List<Transaction> transactionHistory = account.getTransactionHistory();

        assertThat(transactionHistory).isEqualTo(expectedHistory);
    }
}
