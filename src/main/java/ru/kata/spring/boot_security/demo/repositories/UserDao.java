package ru.kata.spring.boot_security.demo.repositories;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUser();

    void saveUser(User user);

    User getUser(Long id);

    void deleteUser(Long id);
}
