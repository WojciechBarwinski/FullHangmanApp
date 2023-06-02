package com.barwinski.FullHangmanApp.entities;

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
            User save = userRepository.save(new User.UserBuilder()
                    .name(userDto.getName())
                    .password(passwordEncoder.encode(userDto.getPassword())).build());
            return new UserDto(save.getName(), save.getPassword());
        }
        return userDto;
    }

    public UserDetails findUserByName(String name){
        return userRepository.findAll()
                .stream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new UsernameNotFoundException("No user was found"));

    }
}
