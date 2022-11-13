package com.example.backend.services.role;
import com.example.backend.entities.Role;
import java.util.List;

public interface RoleService {
    List<Role> findAll();
    Role updateOne(Role role);
    Role insertOne(Role role);
    Role findById(int id);
    boolean deleteOne(int id);
}
