package com.bankflow.bankflow_api.repository;

import com.bankflow.bankflow_api.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, String> {
    Optional<Customer> findByEmail(String email);
    Optional<Customer> findByNationalId(String nationalId);
}