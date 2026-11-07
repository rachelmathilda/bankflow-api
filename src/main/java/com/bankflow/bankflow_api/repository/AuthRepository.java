package com.bankflow.bankflow_api.repository;
import com.bankflow.bankflow_api.domain.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Auth findByUsername(String username);
    boolean existsByUsername(String username);
}