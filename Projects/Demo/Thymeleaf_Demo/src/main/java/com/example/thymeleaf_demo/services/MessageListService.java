package com.example.thymeleaf_demo.services;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageListService {
    private List<String> messageList;

    @PostConstruct
    public void postConstruct() {
        messageList = new ArrayList<>();
    }

    public void addMessage(String message) {
        messageList.add(message);
    }


    public List<String> getMessages() {
        return new ArrayList<>(messageList);
    }
}
