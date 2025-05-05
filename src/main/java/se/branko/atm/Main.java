package se.branko.atm;

import se.branko.atm.service.AuthService;

public class Main {
    public static void main(String[] args) {


        AuthService authService = new AuthService();

        authService.login("12345678", "1234");

    }
}
