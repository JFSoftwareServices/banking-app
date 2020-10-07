package com.jfsoftware.bankingapp.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name = "account")
public class Account implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long accountId;

    @Column(unique = true, nullable = false)
    @NotEmpty(message = "accountNumber cannot be missing or empty")
    @Size(min = 7, max = 7, message = "accountNumber must be 7 characters")
    private String accountNumber;

    @NotNull(message = "currentBalance cannot be missing or empty")
    @DecimalMin(value = "0.0", message = "currentBalance cannot be negative")
    @Digits(integer = 10, fraction = 2, message = "currentBalance integral digits cannot be greater than 10 and " +
            "factional digits greater than 2")
    private BigDecimal currentBalance;
}