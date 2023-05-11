package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
//    @Transactional
    public List<Role> getAllRoles() {
        return roleRepositories.findAll();
    }

    @Override
//    @Transactional
    public Role getRoleById(Long id) {
        return roleRepositories.findById(id);
    }

    @Override
    @Transactional
    public void addRole(Role role) {
        roleRepositories.save(role);
    }
}
