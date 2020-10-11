package com.jfsoftware.bankingapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ResponseStatementDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private BigDecimal currentBalance;
    private List<ResponseTransactionDTO> transactionHistory;
}