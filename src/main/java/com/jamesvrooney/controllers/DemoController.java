package com.jamesvrooney.controllers;

import com.jamesvrooney.models.UserDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class DemoController {

    private final UserDetailsManager userDetailsManager;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("demo")
    public String demo() {

        log.info("Testing /demo endpoint");

        final var greeting = "Hello James";

        return greeting;
    }

    @PostMapping("user")
    public void addUser(@RequestBody UserDto user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDetailsManager.createUser(user);
    }
}
