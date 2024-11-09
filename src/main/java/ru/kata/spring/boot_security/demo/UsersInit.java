package ru.kata.spring.boot_security.demo;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;

import javax.annotation.PostConstruct;
@Component
public class UsersInit {

    private final UserService userService;
    private final RoleService roleService;

    public UsersInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void createUsers() {
        Role user = new Role("ROLE_USER");
        Role admin = new Role("ROLE_ADMIN");

        roleService.save(user);
        roleService.save(admin);

        User user1 = new User("ron@mail.ru", "111");
        User user2 = new User("fred@mail.ru","111");
        User user3 = new User("messi@mail.ru", "111");

        user1.setRole(roleService.findByName("ROLE_ADMIN"));
        user1.setRole(roleService.findByName("ROLE_USER"));
        user2.setRole(roleService.findByName("ROLE_ADMIN"));
        user3.setRole(roleService.findByName("ROLE_USER"));

        user3.setFirstName("Ronaldo");
        user3.setLastName("Cristiano");
        user3.setAge(37);

        user1.setFirstName("Fred");
        user1.setLastName("Pip");
        user1.setAge(30);

        user2.setFirstName("Lionel");
        user2.setLastName("Messi");
        user2.setAge(34);

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);

    }

}
