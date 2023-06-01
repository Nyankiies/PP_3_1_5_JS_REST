package ru.kata.spring.boot_security.demo.service;



import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    void saveUser(User user);
    void deleteUser(Long id);
    User getById(Long id);
    User findByUsername(String username);
}
