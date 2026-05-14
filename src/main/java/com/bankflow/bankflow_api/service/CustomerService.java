package com.bankflow.bankflow_api.service;

import com.bankflow.bankflow_api.domain.Customer;
import com.bankflow.bankflow_api.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getById(String id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}