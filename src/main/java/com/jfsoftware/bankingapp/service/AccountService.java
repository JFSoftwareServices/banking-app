package com.jfsoftware.bankingapp.service;

import com.jfsoftware.bankingapp.controller.request.TransferBalanceRequest;
import com.jfsoftware.bankingapp.dto.AccountStatement;
import com.jfsoftware.bankingapp.entity.Account;
import com.jfsoftware.bankingapp.entity.Transaction;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.LockModeType;
import java.util.List;

@Transactional(isolation = Isolation.SERIALIZABLE)
public interface AccountService {
    @Lock(LockModeType.PESSIMISTIC_READ)
    List<Account> findAll();

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Account create(Account account);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Account findByAccountNumber(String accountNumber);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Transaction sendMoney(TransferBalanceRequest transferBalanceRequest);

    @Lock(LockModeType.PESSIMISTIC_READ)
    AccountStatement getStatement(String accountNumber);
}