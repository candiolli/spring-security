package com.example.demospringsecurityoauth2;

import com.example.demospringsecurityoauth2.model.Role;
import com.example.demospringsecurityoauth2.model.RolesEnum;
import com.example.demospringsecurityoauth2.model.User;
import com.example.demospringsecurityoauth2.repository.RoleRepository;
import com.example.demospringsecurityoauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

public class DataInitializr implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent arg0) {
        List<User> users = userRepository.findAll();

        if (users.isEmpty()) {
            createUser("Admin", "admin", passwordEncoder.encode("123456"), RolesEnum.ROLE_ADMIN.getValor());
            createUser("Cliente", "cliente", passwordEncoder.encode("123456"), RolesEnum.ROLE_CLIENT.getValor());
        }
    }

    public void createUser(String name, String email, String password, String roleName) {
        Role role = new Role(roleName);

        this.roleRepository.save(role);
        User user = new User(name, email, password, Arrays.asList(role));
        userRepository.save(user);
    }

}