package com.example.springmvc_demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.Arrays;

@Controller
public class HomeController {

    @RequestMapping("")
    public String gethomePage(Model model) {
        model.addAttribute("messages", Arrays.asList("Hello", "Hi", "Goodbye"));
        return "home";
    }
}
