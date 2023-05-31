package ru.kata.spring.boot_security.demo.Init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repositories.RoleRepositories;
import ru.kata.spring.boot_security.demo.service.UserServiceImp;

import javax.annotation.PostConstruct;
import java.util.Set;

@Component
public class InitUser {
    private UserServiceImp userServiceImp;
    private RoleRepositories roleRepositories;
    @Autowired
    public void setUserServiceImp(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }
    @Autowired
    public void setRoleRepositories(RoleRepositories roleRepositories) {
        this.roleRepositories = roleRepositories;
    }

    @PostConstruct
    public void init(){
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser  = new Role("ROLE_USER");
        roleRepositories.save(roleAdmin);
        roleRepositories.save(roleUser);

        User user = new User("admin","admin",27,"test@mail.ru","100",Set.of(roleAdmin));
        User user1 = new User("user","user", 27, "user@test.com","100",Set.of(roleUser));
        userServiceImp.saveUser(user);
        userServiceImp.saveUser(user1);
    }
}
