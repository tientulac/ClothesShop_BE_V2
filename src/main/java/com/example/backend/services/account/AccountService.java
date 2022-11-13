package com.example.backend.services.account;

import com.example.backend.entities.Account;

import java.util.List;

public interface AccountService {
    Account findById(int id);
    Account login(String user_name, String password);
    Account save(Account account);
    boolean deleteOne(int id);
    List<Account> findAll();
}
