package com.example.bank.com.example.service;

import com.example.bank.com.example.model.User;
import com.example.bank.com.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {

    @Autowired
    UserRepo userRepo;

    public User createUser(User user){
       return userRepo.save(user);
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUserById(String userId){
        Optional<User> user = userRepo.findById(userId);
        return user.orElse(null);
    }

}
