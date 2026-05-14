package com.bankflow.bankflow_api.repository;

import com.bankflow.bankflow_api.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, String> {
    List<Loan> findByCustomerId(String customerId);
    List<Loan> findByAccountId(String accountId);
}