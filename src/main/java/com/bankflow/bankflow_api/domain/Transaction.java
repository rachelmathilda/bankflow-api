package com.bankflow.bankflow_api.domain;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.bankflow.bankflow_api.domain.enums.TransactionStatus;
import com.bankflow.bankflow_api.domain.enums.TransactionType;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id private String transactionId;
    private String idempotencyKey;
    private String fromAccountId;
    private String toAccountId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private TransactionType type;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    private String description;
    private String failReason;
    private String referenceNumber;
    private Instant timestamp;
    private Instant clearedAt;
    private Instant settledAt;
}
