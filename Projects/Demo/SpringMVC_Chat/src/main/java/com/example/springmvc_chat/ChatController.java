package com.example.springmvc_chat;

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
    String showMessage(Model model, @ModelAttribute("chatMessage") ChatMessage chatMessage) {
        if (chatMessage.getUsername().trim().length() > 0 && chatMessage.getMessageText().trim().length() > 0) {
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
