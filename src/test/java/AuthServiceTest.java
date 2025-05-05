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


}
