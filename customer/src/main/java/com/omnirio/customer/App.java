package com.omnirio.customer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class App {
    // // @Value("${DOMAIN_NAME}")
    // private static String hostname;
    
    // @Value("${HOSTNAME}")
    // public void setHostName(String hostname){
    //     App.hostname = hostname;
    // }
    
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        // System.out.println("DEBUG ==> " + hostname);
    }
}