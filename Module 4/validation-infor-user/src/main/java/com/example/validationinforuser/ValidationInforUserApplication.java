package com.example.validationinforuser;

import com.example.validationinforuser.model.User;
import com.example.validationinforuser.model.UserAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ValidationInforUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidationInforUserApplication.class, args);
    }
    @Bean
    public UserAspect logger() {
        return new UserAspect();
    }

}

