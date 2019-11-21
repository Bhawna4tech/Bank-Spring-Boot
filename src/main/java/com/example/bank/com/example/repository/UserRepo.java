package com.example.bank.com.example.repository;

import com.example.bank.com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,String> {
}
