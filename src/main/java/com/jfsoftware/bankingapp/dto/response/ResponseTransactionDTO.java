package com.jfsoftware.bankingapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseTransactionDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fromAccountNumber;
    private String toAccountNumber;
    private BigDecimal transactionAmount;
    private LocalDateTime transactionDateTime;
}