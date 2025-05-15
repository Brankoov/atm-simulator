import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.branko.atm.model.Account;
import se.branko.atm.service.AuthService;

import static org.junit.jupiter.api.Assertions.*;

public class AuthServiceTest {
    private Account account;
    private AuthService auth;

    @BeforeEach
    void setUp() {
        account = new Account("12345678", "1234", 1000.00);
        auth = new AuthService(account);
    }

    @Test
    void shouldLogInWithCorrectCardNumberAndPassword() {
        boolean result = auth.login("12345678", "1234");
        assertTrue(result);
    }

    @Test
    void loginShouldReturnFalseIfCardNumberIsWrong() {
        assertFalse(auth.login("00000000", "1234"));
    }

    @Test
    void loginShouldReturnFalseIfPinIsWrong() {
        assertFalse(auth.login("12345678", "0000"));
    }
    @Test
    void loginShouldReturnFalseIfCardNumberIsNull() {
        assertFalse(auth.login(null, "1234"));
    }

    @Test
    void loginShouldReturnFalseIfPinIsNull() {
        assertFalse(auth.login("12345678", null));
    }

    @Test
    void loginShouldReturnFalseIfCardNumberIsEmpty() {
        assertFalse(auth.login("", "1234"));
    }

    @Test
    void loginShouldReturnFalseIfPinIsEmpty() {
        assertFalse(auth.login("12345678", ""));
    }

    @Test
    void loginShouldReturnFalseIfBothInputsAreEmpty() {
        assertFalse(auth.login("", ""));
    }

    @Test
    void loginShouldReturnFalseIfBothInputsAreNull() {
        assertFalse(auth.login(null, null));
    }
}