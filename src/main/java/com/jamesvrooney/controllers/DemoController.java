package com.jamesvrooney.controllers;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class DemoController {

    @GetMapping("demo")
    public String demo() {

        log.info("Testing /demo endpoint");

        final var greeting = "Hello demo";

        return greeting;
    }
}
