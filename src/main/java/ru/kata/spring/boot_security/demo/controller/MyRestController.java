package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping("/api")
public class MyRestController {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public List<User> showAllUser() {
        List<User> allUsers = userService.getAllUser();
        return allUsers;
    }
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Long id) {
        User user = userService.getById(id);
        return user;
    }
    @PostMapping("/users")
    public User addUsers(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }

    @PutMapping("/users/{id}")
    public User updateUser(@RequestBody User user) {
        userService.saveUser(user);
        return user;
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {
        System.out.println(id);
        userService.deleteUser(id);
        return "User with ID = " + id + " was delete";
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        List<Role> allRoles = roleService.getAllRoles();
        return allRoles;
    }
    @GetMapping("/roles/{id}")
    public Role getRolesById(@PathVariable Long id) {
        Role roleById = roleService.findById(id);
        return roleById;
    }
    @GetMapping("/viewUser")
    public User showUser(Principal principal) {
        User users = userService.findByUsername(principal.getName());
        return users;
    }
}
