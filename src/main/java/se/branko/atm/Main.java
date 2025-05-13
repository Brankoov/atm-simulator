package se.branko.atm;

import se.branko.atm.model.Account;
import se.branko.atm.service.AtmService;
import se.branko.atm.service.AuthService;
import se.branko.atm.service.Bank;
import se.branko.atm.service.ReceiptService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Account account = new Account("12345678", "1234", 1000.00);
        ReceiptService receiptService = new ReceiptService();
        AuthService authService = new AuthService(account);
        Bank bank = new AtmService(account, receiptService); // Polymorfism!

        boolean loggedIn = false;

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
        boolean running = true;
        while (running) {
            System.out.println("\n--- Meny ---");
            System.out.println("1. Visa saldo");
            System.out.println("2. Sätt in pengar");
            System.out.println("3. Ta ut pengar");
            System.out.println("4. Avsluta");
            System.out.print("Välj ett alternativ: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    bank.showBalance();
                    break;
                case "2":
                    System.out.print("Ange belopp att sätta in: ");
                    double deposit = Double.parseDouble(scanner.nextLine());
                    System.out.println(bank.deposit(deposit));
                    break;
                case "3":
                    System.out.print("Ange belopp att ta ut: ");
                    double withdraw = Double.parseDouble(scanner.nextLine());
                    System.out.println(bank.withdraw(withdraw));
                    break;
                case "4":
                    System.out.println("Tack och hej!");
                    running = false;
                    break;
                default:
                    System.out.println("Ogiltigt val, försök igen.");
            }
        }

        scanner.close();
    }
}