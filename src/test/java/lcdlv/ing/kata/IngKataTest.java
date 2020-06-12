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
}
