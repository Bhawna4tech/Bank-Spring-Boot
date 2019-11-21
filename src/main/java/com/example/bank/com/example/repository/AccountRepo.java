package com.example.bank.com.example.repository;

import com.example.bank.com.example.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,String> {
}
