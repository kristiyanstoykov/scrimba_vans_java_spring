package com.vans.vans.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/")
public class AppController {

    @GetMapping("")
    public String getMainPage() {
        return "Welcome!";
    }

}
