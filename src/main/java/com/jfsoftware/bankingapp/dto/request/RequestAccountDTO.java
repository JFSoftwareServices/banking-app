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
public class RequestAccountDTO {
    @NotEmpty(message = "accountNumber cannot be missing or empty")
    @Size(min = 7, max = 7, message = "accountNumber must be 7 characters")
    private String accountNumber;

    @NotNull(message = "currentBalance cannot be missing or empty")
    @DecimalMin(value = "0.0", message = "currentBalance cannot be negative")
    @Digits(integer = 10, fraction = 2, message = "currentBalance integral digits cannot be greater than 10 and " +
            "factional digits greater than 2")
    private BigDecimal currentBalance;
}