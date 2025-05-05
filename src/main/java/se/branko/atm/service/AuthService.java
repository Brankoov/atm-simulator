package se.branko.atm.service;

import se.branko.atm.model.Account;

public class AuthService {
    Account account = new Account("12345678", "1234", 1000.00);
    ReceiptService receiptService = new ReceiptService();

    public boolean login(String cardNumber, String pin) {
        return "12345678".equals(cardNumber)&&"1234".equals(pin);

    }
    public Account getAccount() {
        return account;
    }

    public String deposit(double amount) {
        if (amount > 0) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            return receiptService.generateDepositReceipt(amount, newBalance);
        }
        return "Ogiltigt belopp.";
    }
    public boolean withdraw(double amount) {
        if (amount > account.getBalance()) {
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        return true;
    }



}
