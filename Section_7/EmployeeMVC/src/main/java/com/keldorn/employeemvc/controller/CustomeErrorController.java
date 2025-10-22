package com.keldorn.employeemvc.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomeErrorController implements ErrorController {

    @RequestMapping("/error")
    public String errorFallback() {
        return "redirect:https://www.youtube.com/watch?v=dQw4w9WgXcQ";
    }
}
