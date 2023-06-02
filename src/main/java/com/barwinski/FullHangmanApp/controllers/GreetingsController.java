package com.barwinski.FullHangmanApp.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/greeting")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "testowy controller")
public class GreetingsController {


    @Operation(
            description = "powitanie dla usera",
            summary = "to jest testowy get dla zalogowanych userow"
    )
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello from base controller");
    }

    @GetMapping("/bye")
    public ResponseEntity<String> sayBey(){
        return ResponseEntity.ok("bye bye");
    }
}
