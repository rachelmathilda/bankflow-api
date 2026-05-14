package com.bankflow.bankflow_api.exception;

import java.math.BigDecimal;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(BigDecimal balance, BigDecimal amount) {
        super("Insufficient balance. Current: " + balance + ", Required: " + amount);
    }
}