package com.rigo.springboot.di.error.springboot_error.services;

import com.rigo.springboot.di.error.springboot_error.models.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserSerive {

    Optional<User> findByUserByid(Long id);
    List<User> findAll();
}
