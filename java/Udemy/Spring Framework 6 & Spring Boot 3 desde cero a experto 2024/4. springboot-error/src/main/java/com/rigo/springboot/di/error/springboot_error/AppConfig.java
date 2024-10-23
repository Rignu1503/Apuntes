package com.rigo.springboot.di.error.springboot_error;

import com.rigo.springboot.di.error.springboot_error.models.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    List<User> UserSeriveImpl() {

        List<User> users = new ArrayList<>();
        users.add(new User(1L, "John", "Doe"));
        users.add(new User(2L, "Jane", "Doe"));
        users.add(new User(3L, "Jack", "Doe"));
        users.add(new User(4L, "Jack", "Doe"));

        return users;
    }
}
