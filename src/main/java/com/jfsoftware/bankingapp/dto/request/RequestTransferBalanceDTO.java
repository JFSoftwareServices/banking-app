package com.jfsoftware.bankingapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestTransferBalanceDTO {
    @NotEmpty(message = "fromAccountNumber cannot be missing or empty")
    @Size(min = 7, max = 7, message = "fromAccountNumber must be 7 characters")
    private String fromAccountNumber;

    @NotEmpty(message = "toAccountNumber cannot be missing or empty")
    @Size(min = 7, max = 7, message = "toAccountNumber must be 7 characters")
    private String toAccountNumber;

    @NotNull(message = "amount cannot be missing or empty")
    @DecimalMin(value = "0.0", message = "amount cannot be negative")
    @Digits(integer = 10, fraction = 2, message = "amount integral digits cannot be greater than 10 and " +
            "factional digits greater than 2")
    private BigDecimal amount;
}