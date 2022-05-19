package com.interview.palindrome.controller;

import com.interview.palindrome.model.Message;
import com.interview.palindrome.model.ProcessedMessage;
import com.interview.palindrome.service.MessageProcessorService;
import com.interview.palindrome.validator.MessageValidator;
import com.interview.palindrome.validator.ValidatorResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("message-rest")
public class MessageController {

    MessageProcessorService messageProcessorService;
    MessageValidator messageValidator;

    @Autowired
    public MessageController(MessageProcessorService messageProcessorService, MessageValidator messageValidator) {
        this.messageProcessorService = messageProcessorService;
        this.messageValidator = messageValidator;
    }

    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProcessedMessage>> getProcessedMessage() {
        return new ResponseEntity<>(messageProcessorService.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addMessage(@RequestBody Message message) {
        ValidatorResult result = messageValidator.validate(message);
        if (!result.isValid()) {
            return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
        }
        messageProcessorService.saveMessage(message);
        return new ResponseEntity<>("Message saved successfully",HttpStatus.OK);
    }

}
