package lcdlv.ing.kata;

import lcdlv.ing.kata.exception.WrongAmountException;
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
    void returns_true_when_client_withdraws_one_from_not_empty_account() throws WrongAmountException {
        Account account = new Account(new Amount(10.00));
        account.withdraw(new Amount(1.00));

        assertThat(account.getBalance()).isEqualTo(10.00 - 1.00);
    }

    @ParameterizedTest
    @ValueSource(doubles = {20, 19.99, 5, 1})
    void returns_true_when_client_withdraws_amounts_from_his_account(double amount) throws WrongAmountException {
        Account account = new Account(new Amount(20.00));
        account.withdraw(new Amount(amount));

        assertThat(account.getBalance()).isBetween(0.0, 20.00);
    }

    @ParameterizedTest
    @ValueSource(doubles = {13, -1, 0, 0.009, 12.51})
    void throws_exception_when_the_amount_withdrawn_is_wrong(double amount) {
        Account account = new Account(new Amount(12.50));
        assertThatThrownBy(() -> account.withdraw(new Amount(amount))).isInstanceOf(WrongAmountException.class)
        .hasMessage("Wrong amount ! You don't have enough in your account");
    }
}
