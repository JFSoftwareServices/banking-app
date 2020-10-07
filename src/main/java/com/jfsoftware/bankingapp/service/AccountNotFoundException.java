package com.jfsoftware.bankingapp.service;

public class AccountNotFoundException extends RuntimeException {
    AccountNotFoundException(String accountNumber) {
        super("Could not find account " + accountNumber);
    }
}