package com.aryan.jounalapp.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.ui.Model;

@RestController
public class healthCheck {
    @GetMapping("/health-check")
    public String healthCheck(){
        return "good";
    }
}
