package com.barwinski.FullHangmanApp.controllers;


import com.barwinski.FullHangmanApp.DTOs.UserDto;
import com.barwinski.FullHangmanApp.entities.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/newUser")
    public UserDto newUser(@RequestBody UserDto UserDto){
        return userService.createUser(UserDto);
    }
}
