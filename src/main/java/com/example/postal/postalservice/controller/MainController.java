package com.example.postal.postalservice.controller;

import com.example.postal.postalservice.entity.Message;
import com.example.postal.postalservice.repository.MessageRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
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
    public List<Message> getAll() {
        return messageRepository.findAll();

    }

    @GetMapping("/api")
    public Message getMessage(@RequestParam int id) {
        return messageRepository.findById(id).orElseThrow();
    }

    @DeleteMapping("/api")
    public void deleteMessage(@RequestParam int id) {
        messageRepository.deleteById(id);
    }

    @PutMapping("/api/add")
    public String changeMessage(@RequestBody Message message) {
        if (!messageRepository.existsById(message.getId())) {
            return "No such row.";
        }
        return messageRepository.save(message).toString();
    }
}
