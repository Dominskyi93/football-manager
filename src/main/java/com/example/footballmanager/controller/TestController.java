package com.example.footballmanager.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TestController {
    @GetMapping("/test")
    public String test() {
        return "Success!";
    }

    @GetMapping("/home")
    public void homePage() {
    }
}
