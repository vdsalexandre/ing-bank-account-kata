package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WithdrawException;
import lcdlv.ing.kata.exception.WrongAmountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DepositTest {

    @Test
    void test_configuration() {
        assertThat(true).isTrue();
    }

    // USER STORY 1 :
    // En tant que banque, j'accepte le dépôt d'argent d'un client vers son compte,
    // s'il est supérieur à 0,01€

    @Test
    void returns_true_when_client_deposits_one_in_his_account() throws WrongAmountException {
        Account account = new Account();
        account.deposit(new Amount(1));

        assertThat(account.getBalance()).isEqualTo(1);
    }

    @Test
    void returns_true_when_client_deposits_an_amount_in_his_account_and_is_equals_to_the_account_balance() throws WrongAmountException {
        Account account = new Account();
        account.deposit(new Amount(10.50));

        assertThat(account.getBalance()).isEqualTo(10.50);
    }

    @Test
    void returns_true_when_client_deposits_two_amounts_in_his_account_and_the_balance_is_still_correct() throws WrongAmountException {
        Account account = new Account();
        account.deposit(new Amount(5.75));
        account.deposit(new Amount(7.50));

        assertThat(account.getBalance()).isEqualTo(13.25);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-25, 0, -0.1, 0.009})
    void throws_amount_exception_when_the_amount_deposit_is_wrong(double amount) {
        Account account = new Account();
        assertThatThrownBy(() -> account.deposit(new Amount(amount))).isInstanceOf(WrongAmountException.class)
                .hasMessage("Wrong amount ! Amount must be greater or equal to 0.01 €");
    }

    @Test
    void returns_true_when_client_deposits_limit_amount_in_his_account_and_the_balance_is_correct() throws WrongAmountException {
        Account account = new Account();
        account.deposit(new Amount(0.01));

        assertThat(account.getBalance()).isEqualTo(0.01);
    }
}
