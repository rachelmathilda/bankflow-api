package com.bankflow.bankflow_api.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Collection;
import java.util.Collections;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
@Entity 
public class Auth implements UserDetails {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public Auth(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override 
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }
}