package se.branko.atm.service;

public interface Bank {
    String deposit(double amount);
    String withdraw(double amount);
    void showBalance();
}
