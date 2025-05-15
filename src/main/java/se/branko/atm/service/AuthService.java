package se.branko.atm.service;

import se.branko.atm.model.Account;


public class AuthService {
    private final Account account;

    public AuthService(Account account) {
        this.account = account;
    }

    public boolean login(String cardNumber, String pin) {
        if (cardNumber == null || pin == null || cardNumber.isEmpty() || pin.isEmpty()) {
            return false;
        }
        return account.getCardNumber().equals(cardNumber) && account.getPin().equals(pin);
    }

    public Account getAccount() {
        return account;
    }
}