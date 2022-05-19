package com.interview.palindrome.controller;

import com.interview.palindrome.model.Message;
import com.interview.palindrome.model.ProcessedMessage;
import com.interview.palindrome.service.MessageProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message-rest")
public class MessageController {

    MessageProcessorService messageProcessorService;

    @Autowired
    public MessageController(MessageProcessorService messageProcessorService) {
        this.messageProcessorService = messageProcessorService;
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProcessedMessage> getProcessedMessage() {
        return messageProcessorService.findAll();
    }

    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addMessage(@RequestBody Message message) {
        messageProcessorService.saveMessage(message);
    }

}
