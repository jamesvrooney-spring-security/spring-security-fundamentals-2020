package com.jamesvrooney.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("demo")
    public String demo() {
        final var greeting = "Hello James";

        return greeting;
    }
}