package com.barwinski.FullHangmanApp.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
public class GreetingsController {


    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from base controller");
    }

    @GetMapping("/bye")
    public ResponseEntity<String> sayBey(){
        return ResponseEntity.ok("bye bye");
    }
}
