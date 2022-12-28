package com.jamesvrooney.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class DemoController {

    @GetMapping("demo")
    public String demo(Authentication authentication) {
        final var name = authentication.getName();

        log.info("Logged in user: {}", name);

        final var greeting = "Hello " + name;

        return greeting;
    }
}
