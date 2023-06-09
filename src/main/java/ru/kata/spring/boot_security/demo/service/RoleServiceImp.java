package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.repositories.RoleRepositories;

import java.util.List;
@Service
public class RoleServiceImp implements RoleService {

    private RoleRepositories roleRepositories;


    @Autowired
    public void setRoleRepositories(RoleRepositories roleRepositories) {
        this.roleRepositories = roleRepositories;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepositories.findAll();
    }

    @Override
    public Role findById(Long id) {
        return roleRepositories.findById(id);
    }
}
