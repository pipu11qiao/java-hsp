package org.example.service;

import org.springframework.stereotype.Component;

@Component
public class PasswordValidator implements Validator {
    @Override
    public void validate(String email, String password, String name) {
        if (!password.matches("^.{6,20}$")) {
            throw new IllegalArgumentException("invalid password");
        }
    }
}
