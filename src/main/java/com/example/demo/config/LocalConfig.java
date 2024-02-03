package com.example.demo.config;

import com.example.demo.domain.AppUser;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {
    @Autowired
    private UserRepository repository;
    @Bean
    public List<AppUser> startDB(){
        AppUser u1 = new AppUser(null, "Alessandro", "agostini@email.com", "123");
        AppUser u2 = new AppUser(null, "Valter", "almeida@email.com", "456");

        return repository.saveAll(List.of(u1, u2));
    }
}
