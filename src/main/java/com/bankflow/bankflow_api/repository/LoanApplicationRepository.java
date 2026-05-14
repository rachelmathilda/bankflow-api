package com.bankflow.bankflow_api.repository;

import com.bankflow.bankflow_api.domain.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, String> {
    List<LoanApplication> findByCustomerId(String customerId);
    List<LoanApplication> findByAccountId(String accountId);
}