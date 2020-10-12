package com.jfsoftware.bankingapp.repository;

import com.jfsoftware.bankingapp.entity.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//https://github.com/eugenp/tutorials/blob/master/spring-boot-modules/spring-boot-testing/src/test/java/com/baeldung/boot/testing/EmployeeRepositoryIntegrationTest.java
@ExtendWith(SpringExtension.class)
@DataJpaTest
class AccountRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    private static final String ACCOUNT_NUMBER_1111111 = "1111111";
    private static final String ACCOUNT_NUMBER_2222222 = "2222222";
    private static final BigDecimal BALANCE_10000_00 = new BigDecimal("10000.00");
    private static final BigDecimal BALANCE_20000_00 = new BigDecimal("20000.00");

    @Test
    void whenFindByAccountNumber_thenReturnAccount() {
        Account created = createAccount(ACCOUNT_NUMBER_1111111, BALANCE_10000_00);
        Account found = accountRepository.findByAccountNumber(ACCOUNT_NUMBER_1111111).orElseThrow();

        assertThat(found.getAccountNumber()).isEqualTo(ACCOUNT_NUMBER_1111111);
        assertThat(found.getCurrentBalance()).isEqualTo(BALANCE_10000_00);
        assertThat(found.getAccountId()).isEqualTo(created.getAccountId());
    }

    @Test
    void whenInvalidAccountNumber_thenReturnNull() {
        Account account = accountRepository.findByAccountNumber("doesNotExist").orElse(null);
        assertThat(account).isNull();
    }

    @Test
    void whenFindById_thenReturnAccount() {
        Account created = createAccount(ACCOUNT_NUMBER_1111111, BALANCE_10000_00);
        Account found = accountRepository.findById(created.getAccountId()).orElseThrow();

        assertThat(found.getAccountNumber()).isEqualTo(ACCOUNT_NUMBER_1111111);
        assertThat(found.getCurrentBalance()).isEqualTo(BALANCE_10000_00);
        assertThat(found.getAccountId()).isEqualTo(created.getAccountId());
    }

    @Test
    void whenInvalidId_thenReturnNull() {
        createAccount(ACCOUNT_NUMBER_1111111, BALANCE_10000_00);
        Account account = accountRepository.findById(-1L).orElse(null);

        assertThat(account).isNull();
    }

    @Test
    void givenSetOfAccounts_whenFindAll_thenReturnAllAccounts() {
        Account account1 = new Account();
        account1.setAccountNumber(ACCOUNT_NUMBER_1111111);
        account1.setCurrentBalance(BALANCE_10000_00);

        Account account2 = new Account();
        account2.setAccountNumber(ACCOUNT_NUMBER_2222222);
        account2.setCurrentBalance(BALANCE_20000_00);

        entityManager.persist(account1);
        entityManager.persist(account2);
        entityManager.flush();

        List<Account> accounts = accountRepository.findAll();

        assertThat(accounts).hasSize(2).extracting(Account::getAccountNumber)
                .containsOnly(account1.getAccountNumber(), account2.getAccountNumber());

        assertThat(accounts).hasSize(2).extracting(Account::getAccountNumber)
                .containsOnly(account1.getAccountNumber(), account2.getAccountNumber());

        assertThat(accounts).hasSize(2).extracting(Account::getCurrentBalance)
                .containsOnly(account1.getCurrentBalance(), account2.getCurrentBalance());
    }

    private Account createAccount(String accountNumber, BigDecimal balance) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setCurrentBalance(balance);
        return entityManager.persistAndFlush(account);
    }

    //TODO add more tests
}