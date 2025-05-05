import org.junit.jupiter.api.Test;
import se.branko.atm.model.AccountService;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AccountServiceTest {
    @Test
    void createAccountShouldReturnNewAccountObject() {
        AccountService accountService = new AccountService();

        boolean result = accountService.createAccount(
                "1234567890", "1234", 1000.0
        );
        assertTrue(result);
    }
}
