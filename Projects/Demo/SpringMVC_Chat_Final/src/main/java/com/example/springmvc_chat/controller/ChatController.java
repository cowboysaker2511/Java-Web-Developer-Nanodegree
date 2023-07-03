package com.example.springmvc_chat.controller;

import com.example.springmvc_chat.MessageType;
import com.example.springmvc_chat.entity.ChatMessage;
import com.example.springmvc_chat.service.MessageService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

    private MessageService messageService;

    public ChatController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public String getHomePage(Model model, @ModelAttribute("chatMessage") ChatMessage chatMessage) {
        model.addAttribute("chatMessages", messageService.getChatMessages());
        return "chat";
    }

    @PostMapping
    String showMessage(Model model, @ModelAttribute("chatMessage") ChatMessage chatMessage, Authentication authentication) {
        if (chatMessage.getMessageText().trim().length() > 0) {
            //get usernmame from authentication
            chatMessage.setUsername(authentication.getName());
            messageService.addMessage(chatMessage);
        }
        model.addAttribute("chatMessages", messageService.getChatMessages());
        return "chat";
    }

    @ModelAttribute("allMessageTypes")
    public MessageType[] getAllMessageTypes() {
        return new MessageType[]{
                new MessageType("Say", 1),
                new MessageType("Shout", 2),
                new MessageType("Whisper", 3)};
    }
}
