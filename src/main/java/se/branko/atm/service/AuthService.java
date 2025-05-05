package se.branko.atm.service;

public class AuthService {
    public boolean login(String cardNumber, String pin) {
        return "12345678".equals(cardNumber)&&"1234".equals(pin);
    }
}
