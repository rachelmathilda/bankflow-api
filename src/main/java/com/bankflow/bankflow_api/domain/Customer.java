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
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.bankflow.bankflow_api.domain.enums.KycStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
    @Id private String customerId;
    private String nationalId;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String address;
    private String passwordHash;
    private LocalDate dateOfBirth;
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private KycStatus kycStatus;

    private LocalDateTime lastLoginAt;
}


