package com.interview.palindrome.controller;

import com.interview.palindrome.constant.MessageConstants;
import com.interview.palindrome.model.Message;
import com.interview.palindrome.model.ProcessedMessage;
import com.interview.palindrome.service.MessageProcessorService;
import com.interview.palindrome.validator.MessageValidator;
import com.interview.palindrome.validator.ValidatorResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.List;

import static com.interview.palindrome.constant.MessageConstants.MESSAGE_SAVED_SUCCESSFULLY;

@ExtendWith(MockitoExtension.class)
public class TestMessageController {

    @Mock
    MessageProcessorService messageProcessorService;

    @Mock
    MessageValidator messageValidator;

    @InjectMocks
    MessageController messageController;

    @Test
    public void testAddMessageSuccess() {
        // Given
        Message testMessage = new Message("TestContent", OffsetDateTime.now());
        Mockito.when(messageValidator.validate(testMessage)).thenReturn(new ValidatorResult(true, MessageConstants.OK));

        // When
        ResponseEntity<?> response = messageController.addMessage(testMessage);

        // Then
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
        Assertions.assertEquals(MESSAGE_SAVED_SUCCESSFULLY, response.getBody());

    }

    @Test
    public void testAddMessageFailure() {
        // Given
        Message testMessage = new Message(null, OffsetDateTime.now());
        Mockito.when(messageValidator.validate(testMessage)).thenReturn(new ValidatorResult(false, MessageConstants.CONTENT_AND_TIMESTAMP_SHOULD_NOT_BE_EMPTY));

        // When
        ResponseEntity<?> response = messageController.addMessage(testMessage);

        // Then
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertEquals(MessageConstants.CONTENT_AND_TIMESTAMP_SHOULD_NOT_BE_EMPTY, response.getBody());

    }

    @Test
    public void testGetProcessedMessages() {
        // Given
        ProcessedMessage processedMessage1 = new ProcessedMessage("TestContent1", OffsetDateTime.now(), 1);
        ProcessedMessage processedMessage2 = new ProcessedMessage("TestContent2", OffsetDateTime.now(), 1);
        ProcessedMessage processedMessage3 = new ProcessedMessage("TestContent3", OffsetDateTime.now(), 1);
        List<ProcessedMessage> processedMessageList = Arrays.asList(processedMessage1, processedMessage2, processedMessage3);

        Mockito.when(messageProcessorService.findAll()).thenReturn(processedMessageList);

        // When
        List<ProcessedMessage> responseList = messageController.getProcessedMessages().getBody();

        // Then
        Assertions.assertEquals(3, responseList.size());
        Assertions.assertEquals("TestContent2", responseList.get(1).getContent());

    }
}
