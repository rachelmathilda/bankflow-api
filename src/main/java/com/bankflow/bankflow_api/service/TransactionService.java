package com.bankflow.bankflow_api.service;

import com.bankflow.bankflow_api.domain.Transaction;
import com.bankflow.bankflow_api.domain.enums.TransactionStatus;
import com.bankflow.bankflow_api.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public Transaction create(Transaction tx) {
        tx.setTimestamp(Instant.now());
        tx.setStatus(TransactionStatus.PENDING);
        return transactionRepository.save(tx);
    }

    public Transaction getById(String id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public List<Transaction> getByFromAccount(String accountId) {
        return transactionRepository.findByFromAccountId(accountId);
    }

    public Transaction update(Transaction tx) {
        return transactionRepository.save(tx);
    }
}