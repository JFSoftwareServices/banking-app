package com.jfsoftware.bankingapp.service;

import com.jfsoftware.bankingapp.controller.request.TransferBalanceRequest;
import com.jfsoftware.bankingapp.dto.AccountStatement;
import com.jfsoftware.bankingapp.entity.Account;
import com.jfsoftware.bankingapp.entity.Transaction;
import com.jfsoftware.bankingapp.repository.AccountRepository;
import com.jfsoftware.bankingapp.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    private TransactionRepository transactionRepository;

    public AccountServiceImpl(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public Account create(Account account) {
        accountRepository.save(account);
        return accountRepository.findByAccountNumber(account.getAccountNumber())
                .orElseThrow(() -> (new AccountNotFoundException(account.getAccountNumber())));
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> (new AccountNotFoundException(accountNumber)));
    }

    @Override
    public Transaction sendMoney(TransferBalanceRequest transferBalanceRequest) {
        String fromAccountNumber = transferBalanceRequest.getFromAccountNumber();
        String toAccountNumber = transferBalanceRequest.getToAccountNumber();
        BigDecimal amount = transferBalanceRequest.getAmount();

        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber)
                .orElseThrow(() -> (new AccountNotFoundException(fromAccountNumber)));

        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> (new AccountNotFoundException(toAccountNumber)));

        if (amount.compareTo(fromAccount.getCurrentBalance()) > 0) {
            throw new InsufficientFundsException(fromAccount);
        }

        fromAccount.setCurrentBalance(fromAccount.getCurrentBalance().subtract(amount));
        accountRepository.save(fromAccount);
        toAccount.setCurrentBalance(toAccount.getCurrentBalance().add(amount));
        accountRepository.save(toAccount);

        return transactionRepository.save(Transaction.builder()
                .transactionId(0L)
                .accountNumber(fromAccountNumber)
                .transactionAmount(amount)
                .transactionDateTime(LocalDateTime.now()).build());
    }

    @Override
    public AccountStatement getStatement(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> (new AccountNotFoundException(accountNumber)));

        return new AccountStatement(account.getCurrentBalance(), transactionRepository
                .findByAccountNumber(accountNumber));
    }
}