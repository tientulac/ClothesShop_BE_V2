package com.example.backend.services.account;

import com.example.backend.entities.Account;
import com.example.backend.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService{
    @Autowired
    AccountRepository accountRepository;

    @Override
    public Account findById(int id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public Account login(String user_name, String password) {
        var list = accountRepository.findAll();
        var acc = new Account();
        for (Account a : list) {
            if (a.getUser_name() == user_name && a.getPassword() == password) {
                acc = a;
            }
            return acc;
        }
        return null;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public boolean deleteOne(int id) {
        Account acc = findById(id);
        if (acc != null) {
            accountRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
