package se.branko.atm.service;

import se.branko.atm.model.Account;

public class AuthService {
    Account account = new Account("12345678", "1234", 1000.00);


    public boolean login(String cardNumber, String pin) {
        return "12345678".equals(cardNumber)&&"1234".equals(pin);

    }
    public Account getAccount() {
        return account;
    }

    public void deposit(double amount) {
        account.setBalance(account.getBalance() + amount);
    }
    public boolean withdraw(double amount) {
        if (amount > account.getBalance()) {
            return false;
        }
        account.setBalance(account.getBalance() - amount);
        return true;
    }

}
