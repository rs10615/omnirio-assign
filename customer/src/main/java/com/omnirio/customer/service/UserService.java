package com.omnirio.customer.service;

import com.omnirio.customer.domain.models.Role;
import com.omnirio.customer.domain.models.User;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private Map<String, User> users;

    public UserService() throws Exception {
        users = new HashMap<>();
        for (User user: listUsers()) {
            users.put(user.getUsername(), user);
        }
    }

    public User findByUsername(String userName) {
        return users.get(userName);
    }

    public List<User> listUsers() throws Exception {
        List<User> users = new ArrayList<>();
        
        User branchManager = new User(
            "god", "god",
            "$2y$12$HMgdxRPDhvCQ.anMdn.EKOIEjOB0aY0g90C6HpqhqGLHLbRQoyFlC", // god
            new Date(0),
            'M',
            new Role("BRANCH_MANAGER", "Branch Manager", "ROLE_BRANCH_MANAGER")
        );

        String minorDOB = "January 2, 2010";
        DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
        
        User customer = new User(
            "dog", "dog",
            "$2y$12$SwUhtJbREYFhA75ij2ackeeQ7Vw16BpAKlS.0Bt4e2VycLqKSFLpy", // dog,
            format.parse(minorDOB),
            'F',
            new Role("CUSTOMER", "Customer", "ROLE_CUSTOMER")
        );

        users.add(branchManager);
        users.add(customer);

        return users;
    }
}