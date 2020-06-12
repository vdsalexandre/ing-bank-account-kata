package lcdlv.ing.kata;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IngKataTest {

    @Test
    void test_configuration() {
        assertThat(true).isTrue();
    }

    // USER STORY 1 :
    // En tant que banque, j'accepte le dépôt d'argent d'un client vers son compte,
    // s'il est supérieur à 0,01€

    @Test
    void returns_true_when_client_deposits_zero_in_his_account() {
        double amount = 0.0;

        Account account = new Account();
        account.deposit(amount);

        assertThat(account.getBalance()).isEqualTo(0.0);
    }

    @Test
    void returns_true_when_client_deposits_an_amount_in_his_account_and_is_equals_to_the_account_balance() {
        double amount = 10.50;

        Account account = new Account();
        account.deposit(amount);

        assertThat(account.getBalance()).isEqualTo(amount);
    }

    @Test
    void returns_true_when_client_deposits_two_amounts_in_his_account_and_the_balance_is_still_correct() {
        double firstAmount = 5.75;
        double secondAmount = 7.50;
        double finalAmount = firstAmount + secondAmount;

        Account account = new Account();
        account.deposit(firstAmount);
        account.deposit(secondAmount);

        assertThat(account.getBalance()).isEqualTo(finalAmount);
    }
}
