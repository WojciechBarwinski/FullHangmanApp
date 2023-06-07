package com.barwinski.FullHangmanApp.services;

import com.barwinski.FullHangmanApp.entities.User;
import com.barwinski.FullHangmanApp.repositories.UserRepository;
import com.barwinski.FullHangmanApp.DTOs.UserDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserDto createUser(UserDto userDto){
        if (userRepository.findByName(userDto.getName()).isEmpty()){
            User save = userRepository.save(User.builder()
                    .name(userDto.getName())
                    .password(passwordEncoder.encode(userDto.getPassword())).build());

            return new UserDto(save.getName(), save.getPassword());
        }
        return userDto;
    }

    public UserDetails findUserByName(String name){
        return userRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));

    }
}
