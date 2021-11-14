package com.omnirio.customer.api;

import com.omnirio.customer.config.security.JwtTokenUtil;
import com.omnirio.customer.domain.models.User;
import com.omnirio.customer.domain.models.dto.AuthRequest;
import com.omnirio.customer.domain.models.dto.CreateUserRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/public")
public class AuthApi {
    
    @Autowired
    private AuthenticationManager authManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody @Valid AuthRequest req) {
        try {
            Authentication authentication = authManager
                    .authenticate(new UsernamePasswordAuthenticationToken(
                        req.getUsername(), req.getPassword())
                    );

            User user = (User) authentication.getPrincipal();
            
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION, jwtTokenUtil.generateAccessToken(user))
                    .build();
                    
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("register")
    public void register(@RequestBody @Valid CreateUserRequest request) {
        
    }
}