package com.jfsoftware.bankingapp.repository;

import com.jfsoftware.bankingapp.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT t FROM Transaction t WHERE t.fromAccountNumber = ?1 OR t.toAccountNumber =?1")
    List<Transaction> findByAccountNumber(String accountNumber);
}