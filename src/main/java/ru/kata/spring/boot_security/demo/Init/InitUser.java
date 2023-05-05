//package ru.kata.spring.boot_security.demo.Init;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.model.Role;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.service.UserServiceImp;
//
//import javax.annotation.PostConstruct;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class InitUser {
//    private UserServiceImp userServiceImp;
//
//    @Autowired
//    public void setUserServiceImp(UserServiceImp userServiceImp) {
//        this.userServiceImp = userServiceImp;
//    }
//
//    @PostConstruct
//    public void init(){
//        Role role = new Role("ROLE_ADMIN");
//
//        Set<Role> adminRole = new HashSet<>();
//        adminRole.add(role);
//
//        User user = new User("admin","admin",27,"test@mail.ru","$2a$12$3sJewj8HepsY/Wk6GMa3tutf2mwBzzRrdqVHaxjvO2LotwGmAF2C6",adminRole); //Pass = 100
//        userServiceImp.saveUser(user);
//    }
//}
