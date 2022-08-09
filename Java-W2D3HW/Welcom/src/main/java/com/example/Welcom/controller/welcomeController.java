package com.example.Welcom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeController {

    @GetMapping("/hey")
    public String hey(){
        return "Hey from spring";
    }

    @GetMapping("/bye")
    public String bye(){
        return "Bye";
    }

    @GetMapping("/check/status")
    public String check(){
        return "Everything OK";
    }

    @GetMapping("/health")
    public String health() {
        return "Server health is up and running";
    }
}
