package com.example.thymeleaf_demo.controllers;

import com.example.thymeleaf_demo.dto.MessageForm;
import com.example.thymeleaf_demo.services.MessageListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/home")
public class HomeController {
    private MessageListService messageListService;

    public HomeController(MessageListService messageListService) {
        this.messageListService = messageListService;
    }

    @GetMapping()
    public String lowFive(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        messageListService.addMessage("low five.");
        model.addAttribute("greetings", messageListService.getMessages());
        return "home";
    }

    @PostMapping()
    public String highFive(@ModelAttribute("newMessage") MessageForm newMessage, Model model) {
        messageListService.addMessage("high five, " + newMessage.getText() + "!");
        model.addAttribute("greetings", messageListService.getMessages());
        newMessage.setText("");
        return "home";
    }
}

