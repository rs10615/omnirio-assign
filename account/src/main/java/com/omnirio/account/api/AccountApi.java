package com.omnirio.account.api;

import com.omnirio.account.domain.models.Account;
import java.util.Collections;
import java.util.List;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "api/accounts")
public class AccountApi {

    @GetMapping
    @Secured( { "ROLE_BRANCH_MANAGER" } )
    public List<Account> listAccounts() {
        return Collections.emptyList();
    }
    
    @GetMapping("/my")
    public Account myAccount() {
        return new Account();
    }

    
}