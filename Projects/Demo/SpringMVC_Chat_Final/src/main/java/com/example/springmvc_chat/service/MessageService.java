package com.example.springmvc_chat.service;

import com.example.springmvc_chat.entity.ChatMessage;
import com.example.springmvc_chat.mapper.MessageMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {
    private List<ChatMessage> chatMessages;
    private final MessageMapper messageMapper;

    public MessageService(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
        chatMessages = new ArrayList<>();
    }

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

}
