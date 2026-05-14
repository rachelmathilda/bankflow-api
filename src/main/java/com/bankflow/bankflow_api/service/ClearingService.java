package com.bankflow.bankflow_api.service;

import com.bankflow.bankflow_api.domain.Transaction;
import com.bankflow.bankflow_api.domain.enums.TransactionStatus;

import java.time.Instant;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class ClearingService {

    private static final ConcurrentHashMap<String, ReentrantLock> locks = new ConcurrentHashMap<>();

    public void clear(Transaction tx) throws InterruptedException {

        String first = tx.getFromAccountId().compareTo(tx.getToAccountId()) < 0
                ? tx.getFromAccountId()
                : tx.getToAccountId();

        String second = first.equals(tx.getFromAccountId())
                ? tx.getToAccountId()
                : tx.getFromAccountId();

        ReentrantLock l1 = locks.computeIfAbsent(first, k -> new ReentrantLock());
        ReentrantLock l2 = locks.computeIfAbsent(second, k -> new ReentrantLock());

        if (l1.tryLock(300, MILLISECONDS)) {
            try {
                if (l2.tryLock(300, MILLISECONDS)) {
                    try {
                        tx.setStatus(TransactionStatus.SUCCESS);
                        tx.setClearedAt(Instant.now());
                    } finally {
                        l2.unlock();
                    }
                } else {
                    fail(tx, "LOCK_TIMEOUT");
                }
            } finally {
                l1.unlock();
            }
        } else {
            fail(tx, "LOCK_TIMEOUT");
        }
    }

    private void fail(Transaction tx, String reason) {
        tx.setStatus(TransactionStatus.FAILED);
        tx.setFailReason(reason);
    }
}