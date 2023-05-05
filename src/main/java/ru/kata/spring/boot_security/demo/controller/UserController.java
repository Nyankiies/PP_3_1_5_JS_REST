package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepositories;
import ru.kata.spring.boot_security.demo.service.UserDetailsImp;

import java.security.Principal;


@Controller
@RequestMapping("/user/")
public class UserController {
    private UserRepositories userRepositories;
    @Autowired
    public void setUserRepositories(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @GetMapping("/")
    public String printWelcome(Model model, Principal principal) {
        User user = userRepositories.findByUsername(principal.getName());
        model.addAttribute("AllUser", user);
        return "user";
    }

}
