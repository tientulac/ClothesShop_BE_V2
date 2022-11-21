package com.example.backend.controller;

import com.example.backend.entities.Role;
import com.example.backend.services.role.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/role") // router
public class RoleController {
    @Autowired
    RoleService roleService;
    //CODE: 01-ADMIN, 02-Shopkeeper, 03-Customer

    @RequestMapping(method = RequestMethod.GET)
    public List<Role> getList() {
        try {
            List<Role> list = roleService.findAll();
            return list;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public Role save(@RequestBody Role role) {
        try {
            if (role.getRole_id() > 0) {
                role.setUpdate_at(new Date());
                role = roleService.updateOne(role);
            }
            else {
                role.setCreated_at(new Date());
                role = roleService.insertOne(role);
            }
            return role;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        try {
            Boolean rs = false;
            if (roleService.deleteOne(id)) {
                rs = true;
            }
            return rs;
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
}
