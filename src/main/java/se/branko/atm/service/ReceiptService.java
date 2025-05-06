package se.branko.atm.service;

public class ReceiptService {

    public String generateDepositReceipt(double amount, double newBalance) {
        return "*--------------------*\n" +
                "Insättning: " + amount + " kr\n" +
                "Ny balans: " + newBalance + " kr\n" +
                "Tack för besöket!\n" +
                "*--------------------*";
    }

    public String generateWithdrawReceipt(double amount, double newBalance) {
        return "*--------------------*\n" +
                "Uttag: " + amount + " kr\n" +
                "Ny balans: " + newBalance + " kr\n" +
                "Tack för besöket!\n" +
                "*--------------------*";
    }
}