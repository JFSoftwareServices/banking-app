package com.jfsoftware.bankingapp.service;

import com.jfsoftware.bankingapp.dto.request.RequestTransferBalanceDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseStatementDTO;
import com.jfsoftware.bankingapp.dto.response.ResponseTransactionDTO;
import com.jfsoftware.bankingapp.entity.Account;
import com.jfsoftware.bankingapp.entity.Transaction;
import com.jfsoftware.bankingapp.repository.AccountRepository;
import com.jfsoftware.bankingapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.jfsoftware.bankingapp.service.ModelMapperService.mapList;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

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
    public Transaction sendMoney(RequestTransferBalanceDTO transferBalanceRequest) {
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

        Transaction transaction = new Transaction(fromAccountNumber, toAccountNumber, amount);
        fromAccount.debit(amount);
        toAccount.credit(amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        fromAccount.addTransaction(transaction);
        transaction.addAccount(fromAccount);
        toAccount.addTransaction(transaction);
        transaction.addAccount(toAccount);

        return transactionRepository.save(transaction);
    }

    @Override
    public ResponseStatementDTO getStatement(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> (new AccountNotFoundException(accountNumber)));

        List<ResponseTransactionDTO> responseTransactionDTOS = mapList(account.getTransactions(),
                ResponseTransactionDTO.class);

        return ResponseStatementDTO.builder()
                .currentBalance(account.getCurrentBalance())
                .transactionHistory(responseTransactionDTOS).build();
    }
}