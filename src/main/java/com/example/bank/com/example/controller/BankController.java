package com.example.bank.com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {

    @GetMapping(path = "/home")
    public ResponseEntity<Object> getHome() {
        return new ResponseEntity<>("Hello Everyone", HttpStatus.OK);
    }

}
