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

import static com.interview.palindrome.constant.MessageConstants.MESSAGE_SAVED_SUCCESSFULLY;

@RestController
@RequestMapping("/v1")
public class MessageController {

    MessageProcessorService messageProcessorService;
    MessageValidator messageValidator;

    @Autowired
    public MessageController(MessageProcessorService messageProcessorService, MessageValidator messageValidator) {
        this.messageProcessorService = messageProcessorService;
        this.messageValidator = messageValidator;
    }

    /**
     * <p>This is a method used for getting all the persisted and
     * processed messages from the database.</p>
     * @return the list of the processed messages inside a
     * ResponseEntity object with an HTTP status.
     */
    @GetMapping(value = "/messages/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProcessedMessage>> getProcessedMessages() {
        return new ResponseEntity<>(messageProcessorService.findAll(), HttpStatus.OK);
    }

    /**
     * <p>This method is used to add a new message.</p>
     * @param message the message what the user wants to add
     * @return a ResponseEntity object containing the response message
     * and the HTTP status.
     */
    @PostMapping(value = "/messages/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addMessage(@RequestBody Message message) {
        ValidatorResult result = messageValidator.validate(message);
        if (!result.isValid()) {
            return new ResponseEntity<>(result.getMessage(),HttpStatus.BAD_REQUEST);
        }
        messageProcessorService.saveMessage(message);
        return new ResponseEntity<>(MESSAGE_SAVED_SUCCESSFULLY,HttpStatus.OK);
    }

}
