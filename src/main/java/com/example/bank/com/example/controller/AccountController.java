package com.example.bank.com.example.controller;

import com.example.bank.com.example.model.Account;
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
public class AccountController {

    @Autowired
    BankService bankService;

    @PostMapping(path = "/accounts")
    public ResponseEntity<Object> createAccount(@RequestBody Account account){
        Account accountCreated = bankService.createAccount(account);
        if(accountCreated.getAccountId() == null){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(accountCreated, HttpStatus.OK);
    }

    @GetMapping(path = "/accounts")
    public ResponseEntity<Object> getAllAccounts() {
        List<Account> accounts = bankService.getAllAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping(path = "accounts/{accountId}")
    public ResponseEntity<Object> getAccountById(@PathVariable(name = "accountId") String accountId){
        Account account = bankService.getAccountById(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

}
