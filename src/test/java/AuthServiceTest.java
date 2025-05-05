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
}
