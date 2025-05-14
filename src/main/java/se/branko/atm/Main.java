package se.branko.atm;

import se.branko.atm.model.Account;
import se.branko.atm.service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Account account = new Account("12345678", "1234", 1000.00);
        ReceiptService receiptService = new ReceiptService();
        AuthService authService = new AuthService(account);
        Bank atmService = new AtmService(account, receiptService);

        AtmController controller = new AtmController(authService, atmService);
        controller.run();
    }
}