package se.branko.atm.service;

public class ReceiptService {

    public String generateReceipt(double amount, double newBalance) {
        return "*--------------------*\n" +
                "Insättning: " + amount + " kr\n" +
                "Ny balans: " + newBalance + " kr\n" +
                "Tack för besöket!\n" +
                "*--------------------*";
    }
}