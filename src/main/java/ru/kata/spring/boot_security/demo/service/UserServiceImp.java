package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.UserRepositories;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    private UserRepositories userRepositories;
    @Autowired
    public void setUserRepositories(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }
    @Override
//    @Transactional
    public List<User> getAllUser() {
        return userRepositories.findAll();
    }
    @Override
    @Transactional
    public void saveUser(User user) {
        userRepositories.save(user);
    }

    @Override
//    @Transactional
    public User getUser(Long id) {
        return userRepositories.getById(id);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepositories.deleteById(id);
    }
}
