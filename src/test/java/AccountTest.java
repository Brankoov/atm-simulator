import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {


    @Test
    void shouldLogInWithCorrectCardNumberAndPassword() {
        AccountTest accountTest = new AccountTest();

        boolean result = accountTest.login("12345678","1234");
        assertTrue(result);

    }
}
