package com.jfsoftware.bankingapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseAccountDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String accountNumber;
    private BigDecimal currentBalance;
    private List<ResponseTransactionDTO> transactions;
}