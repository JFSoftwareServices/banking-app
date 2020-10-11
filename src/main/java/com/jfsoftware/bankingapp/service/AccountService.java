package com.jfsoftware.bankingapp.service;

import com.jfsoftware.bankingapp.dto.request.RequestTransferBalanceDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseStatementDTO;
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
    Transaction sendMoney(RequestTransferBalanceDTO transferBalanceRequest);

    @Lock(LockModeType.PESSIMISTIC_READ)
    ResponseStatementDTO getStatement(String accountNumber);
}