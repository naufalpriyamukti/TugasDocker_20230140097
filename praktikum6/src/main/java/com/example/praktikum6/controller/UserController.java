package com.example.praktikum6.controller;

import com.example.praktikum6.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private List<User> userList = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        if ("admin".equals(username) && !password.isEmpty()) {
            return "redirect:/home";
        }
        model.addAttribute("error", "Username atau Password salah");
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", userList);
        return "home"; // Mengarah ke home.html
    }

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form"; // Mengarah ke form.html
    }
}