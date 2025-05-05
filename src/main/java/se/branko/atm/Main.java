package se.branko.atm;

import se.branko.atm.service.AuthService;

public class Main {
    public static void main(String[] args) {


        AuthService authService = new AuthService();

        boolean loginSuccess = authService.login("12345678", "1234");
        System.out.println(loginSuccess);


        // Anropar withdraw och skriver ut kvittot för uttaget
        String withdrawReceipt = authService.withdraw(200);
        System.out.println(withdrawReceipt);

        String depositReceipt = authService.deposit(200);
        System.out.println(depositReceipt);

    }
}
