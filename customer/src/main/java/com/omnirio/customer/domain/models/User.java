package com.omnirio.customer.domain.models;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
    private boolean enabled = true;
    
    private String userId; 
    private String userName;
    private String password;
    
    private Date dateOfBirth;
    private char gender; // 'M' or 'F'
    private Role role;
    
    public User() { }
    
    public User(
        String userId, 
        String userName,
        String password,
        Date dateOfBirth,
        char gender,
        Role role) {
        
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.role = role;
    }
    
    public String getId() {
        return userId;
    }

    @Override
    public Collection<? extends org.springframework.security.core.GrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority(role.getRoleCode()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return enabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return enabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}