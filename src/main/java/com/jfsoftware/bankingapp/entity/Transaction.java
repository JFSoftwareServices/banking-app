package com.jfsoftware.bankingapp.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity
@Builder
@Table(name = "transaction")
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long transactionId;

    @NotEmpty(message = "accountNumber cannot be missing or empty")
    @Size(min = 7, max = 7, message = "accountNumber must be 7 characters")
    @Column(nullable = false)
    private String accountNumber;

    @NotNull(message = "transactionAmount cannot be missing or empty")
    @DecimalMin(value = "0.0", message = "transactionAmount cannot be negative")
    @Digits(integer = 10, fraction = 2, message = "transactionAmount integral digits cannot be greater than 10 and " +
            "factional digits greater than 2")
    private BigDecimal transactionAmount;

    @CreatedDate
    private LocalDateTime transactionDateTime = LocalDateTime.now();
}