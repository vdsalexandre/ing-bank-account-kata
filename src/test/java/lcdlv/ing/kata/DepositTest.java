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
        double amount = 1;

        Account account = new Account();
        account.deposit(amount);

        assertThat(account.getBalance()).isEqualTo(1);
    }

    @Test
    void returns_true_when_client_deposits_an_amount_in_his_account_and_is_equals_to_the_account_balance() throws WrongAmountException {
        double amount = 10.50;

        Account account = new Account();
        account.deposit(amount);

        assertThat(account.getBalance()).isEqualTo(amount);
    }

    @Test
    void returns_true_when_client_deposits_two_amounts_in_his_account_and_the_balance_is_still_correct() throws WrongAmountException {
        double firstAmount = 5.75;
        double secondAmount = 7.50;
        double finalAmount = firstAmount + secondAmount;

        Account account = new Account();
        account.deposit(firstAmount);
        account.deposit(secondAmount);

        assertThat(account.getBalance()).isEqualTo(finalAmount);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-25, 0, -0.1, 0.009})
    void throws_amount_exception_when_the_amount_deposit_is_wrong(double amount) {
        Account account = new Account();
        assertThatThrownBy(() -> account.deposit(amount)).isInstanceOf(WrongAmountException.class)
                .hasMessage("Wrong amount ! Amount must be greater or equal to 0.01 €");
    }

    @Test
    void returns_true_when_client_deposits_limit_amount_in_his_account_and_the_balance_is_correct() throws WrongAmountException {
        double amount = 0.01;
        double limitAmount = 0.01;

        Account account = new Account();
        account.deposit(amount);

        assertThat(account.getBalance()).isEqualTo(limitAmount);
    }
}
