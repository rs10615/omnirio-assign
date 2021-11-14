package com.omnirio.account.client;

import com.omnirio.account.config.security.FeignConfig;
import com.omnirio.account.domain.models.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient( value = "customer-service", configuration = FeignConfig.class)
public interface UserApiClient {

    @RequestMapping( value = "/api/users/me", method = RequestMethod.GET)
    User me(@RequestHeader("Authorization") String auth);
    
}