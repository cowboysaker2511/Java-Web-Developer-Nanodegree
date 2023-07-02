package com.example.springmvc_chat;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MessageService {
    private List<ChatMessage> chatMessages;

    public List<ChatMessage> getChatMessages() {
        return new ArrayList<>(chatMessages);
    }

    public void addMessage(ChatMessage chatMessage) {
        if (chatMessage.getMessageType() == 2) {
            chatMessage.setMessageText(chatMessage.getMessageText().toUpperCase());
        } else if (chatMessage.getMessageType() == 3) {
            chatMessage.setMessageText(chatMessage.getMessageText().toLowerCase());
        }
        chatMessages.add(chatMessage);
    }

    @PostConstruct
    public void postConstruct() {
        chatMessages = new ArrayList<>();
    }
}
