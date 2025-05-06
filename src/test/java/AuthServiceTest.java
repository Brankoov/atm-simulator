import org.junit.jupiter.api.Test;
import se.branko.atm.service.AuthService;
import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {



    @Test
    void shouldLogInWithCorrectCardNumberAndPassword() {
        AuthService authServiceTest = new AuthService();

        boolean result = authServiceTest.login("12345678","1234");
        assertTrue(result);
    }
    @Test
    void loginShouldReturnFalseIfCardNumberIsWrong() {
        AuthService auth = new AuthService();
        assertFalse(auth.login("00000000", "1234"));
    }

    @Test
    void loginShouldReturnFalseIfPinIsWrong() {
        AuthService auth = new AuthService();
        assertFalse(auth.login("12345678", "0000"));
    }


    @Test
    void testGetBalanceShouldReturnCurrentBalance() {
        AuthService auth = new AuthService();
        auth.login("12345678", "1234");

        double balance = auth.getAccount().getBalance();
        assertEquals(1000.00, balance);
    }

    @Test
    void testDepositShouldIncreaseBalance() {
        AuthService auth = new AuthService();
        auth.login("12345678", "1234");

        auth.deposit(500.00); // Skapa denna metod!
        assertEquals(1500.00, auth.getAccount().getBalance());
    }

    @Test
    void testWithdrawShouldDecreaseBalanceIfEnoughMoney() {
        AuthService auth = new AuthService();
        auth.login("12345678", "1234");

        // Testa uttag och kontrollera om kvittot innehåller rätt information
        String result = auth.withdraw(300);
        assertTrue(result.contains("Uttag: 300"));
        assertTrue(result.contains("Ny balans:"));
        assertEquals(700.00, auth.getAccount().getBalance());
    }
    @Test
    void testWithdrawShouldFailIfNotEnoughMoney() {
        AuthService auth = new AuthService();
        auth.login("12345678", "1234");

        // Försök med ett uttag större än balansen och kolla om rätt felmeddelande returneras
        String result = auth.withdraw(2000.00);
        assertEquals("Otillräckligt saldo. Uttag misslyckades.", result);
        assertEquals(1000.00, auth.getAccount().getBalance());
    }
    @Test
    void depositShouldGenerateCorrectReceipt() {
        AuthService authService = new AuthService();
        String receipt = authService.deposit(200);
        assertTrue(receipt.contains("Insättning: 200"));
        assertTrue(receipt.contains("Ny balans:"));
    }
    @Test
    void withdrawShouldGenerateCorrectReceipt() {
        AuthService authService = new AuthService();
        String receipt = authService.withdraw(200);

        // Kontrollera att kvittot för uttaget genererades korrekt
        assertTrue(receipt.contains("Uttag: 200"));
        assertTrue(receipt.contains("Ny balans:"));
    }




}
