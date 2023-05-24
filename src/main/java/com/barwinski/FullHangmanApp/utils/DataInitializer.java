package com.barwinski.FullHangmanApp.utils;

import com.barwinski.FullHangmanApp.entities.User;
import com.barwinski.FullHangmanApp.repositories.UserRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
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
        return Arrays.asList(
                new User("admin", passwordEncoder.encode("1234"), true, true, true, true),
                new User("user", passwordEncoder.encode("123"),  true, true, true, true)
        );
    }
}
