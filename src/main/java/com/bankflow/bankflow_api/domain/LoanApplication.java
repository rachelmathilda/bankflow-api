package com.bankflow.bankflow_api.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.bankflow.bankflow_api.domain.enums.LoanStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LoanApplication {
    @Id private String applicationId;
    private String customerId;
    private String accountId;
    private BigDecimal requestedAmount;
    private Integer termMonths;
    private String loanPurpose;
    private BigDecimal monthlyIncome;

    @Enumerated(EnumType.STRING)
    private LoanStatus status;
    private BigDecimal approvedAmount;
    private BigDecimal interestRate;
    private BigDecimal monthlyInstallment;
    private String rejectionReason;
    private LocalDateTime appliedAt;
    private LocalDateTime decidedAt;
}
