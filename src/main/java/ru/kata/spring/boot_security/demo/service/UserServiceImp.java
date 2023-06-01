package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepositories;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserRepositories userRepositories;
    private PasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public void setUserRepositories(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @Autowired
    public void setBCryptPasswordEncoder(PasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
//    @Transactional
    public List<User> getAllUser() {
        return userRepositories.findAll();
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepositories.save(user);
    }
    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepositories.deleteById(id);
    }
}
