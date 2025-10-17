package com.keldorn.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/processForm")
    public String shwForm() {
        return "helloworld/helloworld-form";
    }

    @PostMapping("/processForm")
    public String processFormVersionThree(@RequestParam("studentName") String name, Model model) {
        model.addAttribute("message",
                "Hey My Friend from v3! %s".formatted(name.toUpperCase()));
        return "helloworld/helloworld";
    }

    @PostMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        String name = request.getParameter("studentName").toUpperCase();
        model.addAttribute("message", "YO! %s".formatted(name));
        return "helloworld/helloworld";
    }
}
