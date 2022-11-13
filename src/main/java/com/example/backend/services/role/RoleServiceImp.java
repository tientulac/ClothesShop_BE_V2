package com.example.backend.services.role;

import com.example.backend.entities.Role;
import com.example.backend.repositories.CategoryRepository;
import com.example.backend.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role updateOne(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role insertOne(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public boolean deleteOne(int id) {
        Role role = findById(id);
        if (role != null) {
            roleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
