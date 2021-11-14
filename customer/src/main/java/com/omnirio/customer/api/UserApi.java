package com.omnirio.customer.api;

import com.omnirio.customer.domain.models.User;
import com.omnirio.customer.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( path = "api/users")
public class UserApi {
    @Autowired
    private UserService userService;
    
    @GetMapping("me")
    public User me() {
        System.err.println("Endpoint '/me' called.");
        return (User) SecurityContextHolder
            .getContext()
            .getAuthentication()
            .getPrincipal();
    }
    
    @GetMapping
    @Secured({ "ROLE_BRANCH_MANAGER" })
    public List<User> listUsers() throws Exception {
        return userService.listUsers();   
    }

    @PutMapping("/{userId}")
    @Secured( { "ROLE_BRANCH_MANAGER" } )
    public void modifyUser(@PathVariable String userId) {
        
    }
}
