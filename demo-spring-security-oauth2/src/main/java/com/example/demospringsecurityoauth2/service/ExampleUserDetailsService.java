package com.example.demospringsecurityoauth2.service;

import com.example.demospringsecurityoauth2.model.User;
import com.example.demospringsecurityoauth2.repository.UserRepository;
import com.example.demospringsecurityoauth2.repository.UserRepositoryUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExampleUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public ExampleUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Usuário não existe!", username));
        }
        return new UserRepositoryUserDetails(user);
    }

}
