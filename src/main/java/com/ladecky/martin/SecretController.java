package com.ladecky.martin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretController {
    @Value("${db.password:NOT_FOUND}")
    private String dbPassword;

    @GetMapping("/reveal")
    public String reveal() {
        return "The secret fetched from Vault is: " + dbPassword;
    }
}
