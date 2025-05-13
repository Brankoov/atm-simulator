package se.branko.atm.service;

import se.branko.atm.model.ReceiptType;

public class ReceiptService {



    public String generateReceipt(ReceiptType type, double amount, double newBalance) {

        switch (type) {
            case WITHDRAW:
                return "*--------------------*\n" +
                        "Uttag: " + amount + " kr\n" +
                        "Ny balans: " + newBalance + " kr\n" +
                        "Tack för besöket!\n" +
                        "*--------------------*";
                case DEPOSIT:
                    return "*--------------------*\n" +
                            "Insättning: " + amount + " kr\n" +
                            "Ny balans: " + newBalance + " kr\n" +
                            "Tack för besöket!\n" +
                            "*--------------------*";
            default:
                return "Invalid receipt type";
        }

    }
}