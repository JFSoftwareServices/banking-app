package com.jfsoftware.bankingapp.service;

import com.jfsoftware.bankingapp.entity.Account;

public class InsufficientFundsException extends RuntimeException {
    InsufficientFundsException(Account fromAccount) {
        super("Insufficient funds in account: " + fromAccount);
    }
}