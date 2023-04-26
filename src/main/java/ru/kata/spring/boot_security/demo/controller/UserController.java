package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserServiceImp userService;

    @GetMapping("/")
    public String printWelcome(Model model, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("AllUser", user);
        return "user";
    }

}
