package com.barwinski.FullHangmanApp.utils;

import com.barwinski.FullHangmanApp.entities.Role;
import com.barwinski.FullHangmanApp.entities.User;
import com.barwinski.FullHangmanApp.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public DataInitializer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        userRepository.saveAll(createInitUsers());
    }

    private List<User> createInitUsers(){
        User admin = User.builder()
                .name("admin")
                .password(passwordEncoder.encode("1234"))
                .role(Role.ADMIN)
                .build();
        User user = User.builder()
                .name("user")
                .password(passwordEncoder.encode("123"))
                .role(Role.USER)
                .build();

        return Arrays.asList(
                admin, user);
    }
}
