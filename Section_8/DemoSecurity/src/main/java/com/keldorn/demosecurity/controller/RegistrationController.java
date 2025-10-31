package com.keldorn.demosecurity.controller;

import com.keldorn.demosecurity.entity.User;
import com.keldorn.demosecurity.entity.WebUser;
import com.keldorn.demosecurity.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final Logger logger = Logger.getLogger(getClass().getName());
    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showRegistrationPage(Model model) {

        model.addAttribute("webUser", new WebUser());
        return "main/register";
    }

    @PostMapping
    public String processRegistrationPage(@Valid @ModelAttribute("webUser") WebUser webUser,
                                          BindingResult bindingResult,
                                          HttpSession session, Model model) {
        String username = webUser.getUsername();
        logger.info("Processing registration form for: " + username);

        if (bindingResult.hasErrors()) {
            return "main/register";
        }

        User existing = userService.findByUserName(username);
        if (existing != null) {
            model.addAttribute("webUser", new WebUser());
            model.addAttribute("registrationError", "User name already exists.");

            logger.warning("User name already exists.");
            return "main/register";
        }

        userService.save(webUser);
        logger.info("Successfully created user: " + username);
        session.setAttribute("user", webUser);

        return "main/registration-confirmation";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {

        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
