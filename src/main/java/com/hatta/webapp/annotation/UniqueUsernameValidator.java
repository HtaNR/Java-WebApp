/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hatta.webapp.annotation;

import com.hatta.webapp.repository.UserRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Hatta NR
 */
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {
    
    @Autowired
    private UserRepository userRepository;
    @Override
    public void initialize(UniqueUsername a) {
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext cvc) {
        if(userRepository == null){
            return true;
        }
        return userRepository.findByName(username) == null;
    }
    
}
