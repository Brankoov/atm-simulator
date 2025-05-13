package se.branko.atm.service;

import se.branko.atm.model.Account;
import se.branko.atm.model.ReceiptType;

public class AuthService {
    Account account = new Account("12345678", "1234", 1000.00);
    ReceiptService receiptService = new ReceiptService();

    public boolean login(String cardNumber, String pin) {
        return "12345678".equals(cardNumber)&&"1234".equals(pin);

    }
    public void showBalance(){
        System.out.println("Saldo: " + account.getBalance());
    }
    public Account getAccount() {
        return account;
    }

    public String deposit(double amount) {
        if (amount > 0 && amount < 100_000) {
            double newBalance = account.getBalance() + amount;
            account.setBalance(newBalance);
            return receiptService.generateReceipt(ReceiptType.DEPOSIT, amount, newBalance);
        }
        return "Ogiltigt belopp.";
    }
    public String withdraw(double amount) {
        if (amount > account.getBalance()) {
            return "Otillräckligt saldo. Uttag misslyckades.";
        }
        account.setBalance(account.getBalance() - amount);
        return receiptService.generateReceipt(ReceiptType.WITHDRAW, amount, account.getBalance());
    }


}
