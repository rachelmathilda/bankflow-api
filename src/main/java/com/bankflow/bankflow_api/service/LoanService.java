package com.bankflow.bankflow_api.service;

import com.bankflow.bankflow_api.domain.Loan;
import com.bankflow.bankflow_api.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public Loan create(Loan loan) {
        return loanRepository.save(loan);
    }

    public Loan getById(String id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public List<Loan> getByCustomer(String customerId) {
        return loanRepository.findByCustomerId(customerId);
    }

    public Loan update(Loan loan) {
        return loanRepository.save(loan);
    }

    public void delete(String id) {
        loanRepository.deleteById(id);
    }
}