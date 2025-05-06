package se.branko.atm;

import se.branko.atm.service.AuthService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AuthService authService = new AuthService();

        boolean loggedIn = false;

        // Inloggning först
        while (!loggedIn) {
            System.out.print("Kortnummer: ");
            String cardNumber = scanner.nextLine();
            System.out.print("PIN-kod: ");
            String pin = scanner.nextLine();

            loggedIn = authService.login(cardNumber, pin);
            if (!loggedIn) {
                System.out.println("Fel kortnummer eller PIN. Försök igen.\n");
            }
        }



    }
}
