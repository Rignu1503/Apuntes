package com.rigo.springboot.di.error.springboot_error.services;

import com.rigo.springboot.di.error.springboot_error.models.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserSeriveImpl implements UserSerive{

    @Autowired
    private List<User> users;

    @Override
    public Optional<User> findByUserByid(Long id) {

        return users.stream().filter(u -> u.getId().equals(id)).findFirst();


//        for (User u : users) {
//            if (u.getId() == id){
//                user = u;
//                break;
//            }
//        }
        //Si es user el nulo delvuelve un optional.empty() si no un optional de valor
//        return Optional.ofNullable(user);

    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
