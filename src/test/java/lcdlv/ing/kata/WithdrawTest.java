package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WithdrawException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WithdrawTest {

    // USER STORY 2 :
    // En tant que banque, j'accepte le retrait d'argent d'un client depuis son compte,
    // s'il n'utilise pas le découvert

    @Test
    void returns_true_when_client_withdraws_one_from_not_empty_account() throws WithdrawException {
        double amount = 1.00;
        double balance = 10.00;

        Account account = new Account(balance);
        account.withdraw(amount);

        assertThat(account.getBalance()).isEqualTo(balance - amount);
    }

    @ParameterizedTest
    @ValueSource(doubles = {20, 19.99, 5, 1})
    void returns_true_when_client_withdraws_amounts_from_his_account(double amount) throws WithdrawException {
        double balance = 20.00;

        Account account = new Account(balance);
        account.withdraw(amount);

        assertThat(account.getBalance()).isBetween(0.0, balance);
    }

    @ParameterizedTest
    @ValueSource(doubles = {13, -1, 0, 0.009, 12.51})
    void throws_withdraw_exception_when_the_amount_withdraw_is_wrong(double amount) {
        double balance = 12.50;

        Account account = new Account(balance);
        assertThatThrownBy(() -> account.withdraw(amount)).isInstanceOf(WithdrawException.class)
                .hasMessage("Withdraw error ! You don't have enough in your account");
    }
}
