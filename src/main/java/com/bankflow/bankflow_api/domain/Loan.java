package com.bankflow.bankflow_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bankflow.bankflow_api.domain.enums.LoanStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Loan {

    @Id
    private String loanId;

    private String applicationId;

    private String customerId;

    private String accountId;

    private BigDecimal principalAmount;

    private BigDecimal outstandingBalance;

    private BigDecimal interestRate;

    private Integer tenorMonths;

    private BigDecimal monthlyInstallment;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    private LocalDate disbursedDate;

    private LocalDate maturityDate;

    private LocalDate nextPaymentDate;

    private Integer paidInstallments;

    private Integer remainingInstallments;

    private BigDecimal penaltyAmount;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}