package com.bankflow.bankflow_api.domain;

import com.bankflow.bankflow_api.domain.enums.AccountStatus;
import com.bankflow.bankflow_api.domain.enums.AccountType;
import com.bankflow.bankflow_api.domain.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import com.bankflow.bankflow_api.domain.enums.Currency;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account implements UserDetails {

    @Id
    private String accountId;

    private String email;

    private String password;

    private String customerId;

    private String accountNumber;

    private String bankId;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private BigDecimal balance;

    private Currency currency;

    private BigDecimal interestRate;

    private LocalDateTime createdAt;

    private LocalDateTime lastTransactionAt;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return role.getAuthorities();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}