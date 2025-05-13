import org.junit.jupiter.api.Test;
import se.branko.atm.model.Account;
import se.branko.atm.service.AuthService;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {

    @Test
    void shouldLogInWithCorrectCardNumberAndPassword() {
        Account account = new Account("12345678", "1234", 1000.00);
        AuthService authServiceTest = new AuthService(account);
        boolean result = authServiceTest.login("12345678", "1234");
        assertTrue(result);
    }

    @Test
    void loginShouldReturnFalseIfCardNumberIsWrong() {
        Account account = new Account("12345678", "1234", 1000.00);
        AuthService auth = new AuthService(account);
        assertFalse(auth.login("00000000", "1234"));
    }

    @Test
    void loginShouldReturnFalseIfPinIsWrong() {
        Account account = new Account("12345678", "1234", 1000.00);
        AuthService auth = new AuthService(account);
        assertFalse(auth.login("12345678", "0000"));
    }
}