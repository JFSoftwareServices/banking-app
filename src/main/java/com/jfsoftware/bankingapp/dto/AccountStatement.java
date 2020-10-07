package com.jfsoftware.bankingapp.dto;

import com.jfsoftware.bankingapp.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountStatement implements Serializable {
    private static final long serialVersionUID = 1L;
    BigDecimal currentBalance;
    List<Transaction> transactionHistory;
}