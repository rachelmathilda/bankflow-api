package com.bankflow.bankflow_api.repository;

import com.bankflow.bankflow_api.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, String> {
    Optional<Transaction> findByIdempotencyKey(String idempotencyKey);
    List<Transaction> findByFromAccountId(String fromAccountId);
    List<Transaction> findByToAccountId(String toAccountId);
}