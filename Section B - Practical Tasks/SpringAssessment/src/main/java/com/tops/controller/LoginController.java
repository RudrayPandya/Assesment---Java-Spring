package com.tops.controller;

import com.tops.dao.UserDAO;
import com.tops.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @RequestMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute("user") User user, Model model) {

        boolean isValid = userDAO.validateUser(user);

        if (isValid) {
            return "dashboard";
        } else {
            model.addAttribute("error", "Invalid Username or Password");
            return "error";
        }
    }
}