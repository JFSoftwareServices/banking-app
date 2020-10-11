package com.jfsoftware.bankingapp.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long transactionId;

    @Column(nullable = false)
    private String fromAccountNumber;

    @Column(nullable = false)
    private String toAccountNumber;

    private BigDecimal transactionAmount;

    @ManyToMany()
    @JoinTable(name = "TRANSACTION_ACCOUNT",
            joinColumns = @JoinColumn(name = "TRANSACTION_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ID"))
    private List<Account> accounts = new ArrayList<>();

    public Transaction(String fromAccountNumber, String toAccountNumber, BigDecimal amount) {
        this.fromAccountNumber = fromAccountNumber;
        this.toAccountNumber = toAccountNumber;
        this.transactionAmount = amount;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    @CreationTimestamp
    private LocalDateTime transactionDateTime;
}