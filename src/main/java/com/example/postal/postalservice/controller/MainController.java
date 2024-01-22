package com.example.postal.postalservice.controller;

import com.example.postal.postalservice.entity.Message;
import com.example.postal.postalservice.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MainController {

    private final MessageRepository messageRepository;
    private final ObjectMapper objectMapper;

    @PostMapping("/api/add")
    public void addMessage(@RequestBody Message message) {
        log.info("New row" + messageRepository.save(message));
    }
    @SneakyThrows
    @GetMapping("/api/all")
    public String getAll(){
        List<Message> messageList = messageRepository.findAll();
        return objectMapper.writeValueAsString(messageList);
    }
    }
