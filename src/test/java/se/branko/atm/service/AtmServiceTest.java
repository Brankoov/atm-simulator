package se.branko.atm.service;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import se.branko.atm.model.Account;


import static org.junit.jupiter.api.Assertions.*;

public class AtmServiceTest {

    private AtmService atm;

    private Account account;

    @BeforeEach

    void setUp() {

        account = new Account("12345678", "1234", 1000.00);
        ReceiptService receiptService = new ReceiptService();
        atm = new AtmService(account, receiptService);

    }

    @Test

    void testGetBalanceShouldReturnCurrentBalance() {

        assertEquals(1000.00, account.getBalance());

    }

    @Test

    void testDepositShouldIncreaseBalance() {

        atm.deposit(500.00);

        assertEquals(1500.00, account.getBalance());

    }

    @Test

    void testWithdrawShouldDecreaseBalanceIfEnoughMoney() {

        String result = atm.withdraw(300);

        assertTrue(result.contains("Uttag: 300"));

        assertTrue(result.contains("Ny balans:"));

        assertEquals(700.00, account.getBalance());

    }

    @Test

    void testWithdrawShouldFailIfNotEnoughMoney() {

        String result = atm.withdraw(2000.00);

        assertEquals("Otillräckligt saldo. Uttag misslyckades.", result);

        assertEquals(1000.00, account.getBalance());

    }

    @Test

    void depositShouldGenerateCorrectReceipt() {

        String receipt = atm.deposit(200);

        assertTrue(receipt.contains("Insättning: 200"));

        assertTrue(receipt.contains("Ny balans:"));

    }

    @Test

    void withdrawShouldGenerateCorrectReceipt() {

        String receipt = atm.withdraw(200);

        assertTrue(receipt.contains("Uttag: 200"));

        assertTrue(receipt.contains("Ny balans:"));

    }

}
 