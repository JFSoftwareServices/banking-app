package com.jfsoftware.bankingapp.controller.api;

import com.jfsoftware.bankingapp.controller.request.TransferBalanceRequest;
import com.jfsoftware.bankingapp.dto.AccountStatement;
import com.jfsoftware.bankingapp.entity.Account;
import com.jfsoftware.bankingapp.entity.Transaction;
import com.jfsoftware.bankingapp.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class AccountController implements AccountContract {

    final private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public ResponseEntity<Account> create(Account account) {
        log.info("Creating account {}", account);
        ResponseEntity<Account> response = ResponseEntity
                .ok(accountService.create(account));
        log.info("Account {} created", account);
        return response;
    }

    @Override
    public ResponseEntity<List<Account>> findAll() {
        log.info("Looking for all accounts");
        ResponseEntity<List<Account>> response = ResponseEntity
                .ok(accountService.findAll());
        log.info("Found all accounts");
        return response;
    }

    @Override
    public ResponseEntity<Transaction> sendMoney(TransferBalanceRequest transferBalanceRequest) {
        log.info("Transferring {} from account {} to account {}", transferBalanceRequest.getAmount(),
                transferBalanceRequest.getFromAccountNumber(),
                transferBalanceRequest.getToAccountNumber());
        ResponseEntity<Transaction> response = ResponseEntity
                .ok(accountService.sendMoney(transferBalanceRequest));
        log.info("Successfully transferred {} from account {} to account {}", transferBalanceRequest.getAmount(),
                transferBalanceRequest.getFromAccountNumber(),
                transferBalanceRequest.getToAccountNumber());
        return response;
    }

    @Override
    public ResponseEntity<AccountStatement> getStatement(String accountNumber) {
        log.info("Retrieving statement for account {}", accountNumber);
        ResponseEntity<AccountStatement> response = ResponseEntity
                .ok(accountService.getStatement(accountNumber));
        log.info("Retrieved statement for account {}", accountNumber);
        return response;
    }

    @Override
    public ResponseEntity<Account> findByAccountNumber(String accountNumber) {
        log.info("Retrieving account {}", accountNumber);
        ResponseEntity<Account> response = ResponseEntity
                .ok(accountService.findByAccountNumber(accountNumber));
        log.info("Retrieved account {}", accountNumber);
        return response;
    }
}