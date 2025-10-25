package com.keldorn.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping
    public String showHome() {

        return "main/home";
    }

    @GetMapping("/leaders")
    public String showLeaders() {

        return "main/leaders";
    }

    @GetMapping("/systems")
    public String showSystems() {

        return "main/systems";
    }
}
