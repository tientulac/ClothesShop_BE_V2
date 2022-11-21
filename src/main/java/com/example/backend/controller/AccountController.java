package com.example.backend.controller;

import com.example.backend.configs.JwtTokenUtil;
import com.example.backend.dtos.UserInfo;
import com.example.backend.entities.Account;
import com.example.backend.entities.Brand;
import com.example.backend.services.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/account") // router
public class AccountController {
    @Autowired
    AccountService accountService;

    @RequestMapping(method = RequestMethod.GET)
    public List<UserInfo> getList() {
        try {
            List<Account> _lstAccount = accountService.findAll();
            var list = new ArrayList<UserInfo>();
            for (Account account : _lstAccount) {
                var info = new UserInfo();
                info.setAccount_id(account.getAccount_id());
                info.setUser_name(account.getUser_name());
                info.setAvatar(account.getAvatar());
                info.setActive(account.isActive());
                info.setAdmin(account.isAdmin());
                info.setAddress(account.getAddress());
                info.setEmail(account.getEmail());
                info.setPhone(account.getPhone());
                info.setRole_code(account.getRole_code());
                info.setFull_name(account.getFull_name());
                list.add(info);
            }
            return list;
        }
        catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Account findById(@PathVariable int id) {
        try {
            Account acc = accountService.findById(id);
            return acc;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public Boolean delete(@PathVariable int id) {
        try {
            Boolean rs = false;
            if (accountService.deleteOne(id)) {
                rs = true;
            }
            return rs;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Account save(@RequestBody Account account) {
        try {
            Account accUpdate = accountService.findById(account.getAccount_id());
            accUpdate.setUpdate_at(new Date());
            accUpdate.setAddress(account.getAddress());
            accUpdate.setPhone(account.getPhone());
            accUpdate.setFull_name(account.getFull_name());
            accUpdate.setRole_code(account.getRole_code());
            accUpdate.setAdmin(account.isAdmin());
            accUpdate.setActive(account.isActive());
            accUpdate.setEmail(account.getEmail());
            accUpdate = accountService.save(accUpdate);
            return accUpdate;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/login")
    public UserInfo login(@RequestBody Account account) {
        try {
            Account _account = accountService.login(account.getUser_name(), account.getPassword());
            if (_account != null) {
                var tokenConfig = new JwtTokenUtil();
                var info = new UserInfo();
                info.setAccount_id(_account.getAccount_id());
                info.setUser_name(_account.getUser_name());
                info.setAvatar(_account.getAvatar());
                info.setActive(_account.isActive());
                info.setAdmin(_account.isAdmin());
                info.setAddress(_account.getAddress());
                info.setEmail(_account.getEmail());
                info.setPhone(_account.getPhone());
                info.setRole_code(_account.getRole_code());
                var token = tokenConfig.generateToken(info);
                info.setToken(token);
                return info;
            }
            else {
                return null;
            }
        }
        catch (Exception ex) {
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, path = "/register")
    public Account register(@RequestBody Account account) {
        try {
            if (account != null) {
                account.setCreated_at(new Date());
                account = accountService.save(account);
                return account;
            }
            else {
                return null;
            }
        }
        catch (Exception ex) {
            return null;
        }
    }
}
