package se.branko.atm.service;

import se.branko.atm.model.Account;
import se.branko.atm.model.ReceiptType;


public class AtmService implements Bank {
    private final Account account;
    private final ReceiptService receiptService;

    public AtmService(Account account, ReceiptService receiptService) {
        this.account = account;
        this.receiptService = receiptService;
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
    public void showBalance(){
        System.out.println("Saldo: " + account.getBalance());
    }
}
