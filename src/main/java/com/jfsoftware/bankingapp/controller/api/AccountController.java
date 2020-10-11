package com.jfsoftware.bankingapp.controller.api;

import com.jfsoftware.bankingapp.dto.request.RequestAccountDTO;
import com.jfsoftware.bankingapp.dto.request.RequestTransferBalanceDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseAccountDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseStatementDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseTransactionDTO;
import com.jfsoftware.bankingapp.entity.Account;
import com.jfsoftware.bankingapp.service.AccountService;
import com.jfsoftware.bankingapp.service.EntityDTOMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
@RestController
public class AccountController implements AccountContract {

    @Autowired
    private AccountService accountService;

    @Autowired
    private EntityDTOMapService entityDTOMapService;


    @Override
    public ResponseEntity<ResponseAccountDTO> create(RequestAccountDTO requestAccountDTO) {
        log.info("Creating account {}", requestAccountDTO);
        Account account = accountService.create(entityDTOMapService.convertToEntity(requestAccountDTO));
        ResponseAccountDTO accountDTO = entityDTOMapService.convertToDto(accountService.create(account));
        log.info("Account {} created", account);
        return ResponseEntity.ok(accountDTO);
    }

    @Override
    public ResponseEntity<List<ResponseAccountDTO>> findAll() {
        log.info("Looking for all accounts");
        List<ResponseAccountDTO> accounts =
                accountService
                        .findAll()
                        .stream()
                        .map(a -> entityDTOMapService.convertToDto(a))
                        .collect(toList());
        log.info("Found all accounts");
        return ResponseEntity.ok(accounts);
    }

    @Override
    public ResponseEntity<ResponseTransactionDTO> sendMoney(RequestTransferBalanceDTO transferBalanceRequest) {
        log.info("Transferring {} from account {} to account {}", transferBalanceRequest.getAmount(),
                transferBalanceRequest.getFromAccountNumber(),
                transferBalanceRequest.getToAccountNumber());

        ResponseTransactionDTO transaction = entityDTOMapService
                .convertToDto(accountService.sendMoney(transferBalanceRequest));

        log.info("Successfully transferred {} from account {} to account {}", transferBalanceRequest.getAmount(),
                transferBalanceRequest.getFromAccountNumber(),
                transferBalanceRequest.getToAccountNumber());
        return ResponseEntity.ok(transaction);
    }

    @Override
    public ResponseEntity<ResponseStatementDTO> getStatement(String accountNumber) {
        log.info("Retrieving statements for account {}", accountNumber);
        ResponseStatementDTO statement = accountService.getStatement(accountNumber);
        log.info("Retrieved statements for account {}", accountNumber);
        return ResponseEntity.ok(statement);
    }

    @Override
    public ResponseEntity<ResponseAccountDTO> findByAccountNumber(String accountNumber) {
        log.info("Retrieving account {}", accountNumber);
        ResponseAccountDTO accountDTO = entityDTOMapService
                .convertToDto(accountService.findByAccountNumber(accountNumber));
        log.info("Retrieved account {}", accountNumber);
        return ResponseEntity.ok(accountDTO);
    }
}