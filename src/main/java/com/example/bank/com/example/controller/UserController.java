package com.example.bank.com.example.controller;

import com.example.bank.com.example.model.User;
import com.example.bank.com.example.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    BankService bankService;

    @PostMapping(path = "/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User userCreated = bankService.createUser(user);
        if (userCreated.getUserId() == null) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(userCreated, HttpStatus.OK);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<Object> getAllUsers() {
        List<User> users = bankService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping(path = "users/{userId}")
    public ResponseEntity<Object> getUser(@PathVariable(name = "userId") String userId){
        User user = bankService.getUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
