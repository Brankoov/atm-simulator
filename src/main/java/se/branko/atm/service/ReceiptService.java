package se.branko.atm.service;

public class ReceiptService {

    public String generateDepositReceipt(double amount, double newBalance) {
        return "Insättning: " + amount + " kr\nNy balans: " + newBalance + " kr\nTack för besöket!";
    }

    public String generateWithdrawReceipt(double amount, double newBalance) {
        return "Uttag: " + amount + " kr\nNy balans: " + newBalance + " kr\nTack för besöket!";
    }
}