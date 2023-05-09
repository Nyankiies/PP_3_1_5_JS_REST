package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepositories;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserService userService;
    private UserRepositories userRepositories;
    private RoleService roleService;

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setUserRepositories(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String printWelcome(Model model, Principal principal) {
        List<User> allUser = userService.getAllUser();
        User userAuth = userRepositories.findByUsername(principal.getName());
        model.addAttribute("users", userAuth);
        System.out.println(userAuth.toString());
        model.addAttribute("AllUser", allUser);
        model.addAttribute("AllRole", roleService.getAllRoles());
        return "admin";
    }
    @GetMapping("/new")
    public String addNewUser(Model model, Principal principal) {
        User userAuth = userRepositories.findByUsername(principal.getName());
        model.addAttribute("users", userAuth);
        User user = new User();
        model.addAttribute("user",user);
        model.addAttribute("AllRole",roleService.getAllRoles());
        return "user-info";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/admin/";
    }
    @PutMapping("/updateInfo/{id}")
    public String updateUser(@ModelAttribute("user") User user) {
        User user1 = userRepositories.findByUsername(user.getUsername());
        userService.saveUser(user1);
        return "redirect:/admin/";
    }
    @DeleteMapping ("/deleteInfo")
    public String deleteUser(@RequestParam(value= "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/";
    }
}
