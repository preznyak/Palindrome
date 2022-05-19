package com.interview.palindrome.service;

import com.interview.palindrome.model.Message;
import com.interview.palindrome.model.ProcessedMessage;
import com.interview.palindrome.repository.ProcessedMessageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageProcessorService {

    ModelMapper modelMapper;
    PalindromeFinder palindromeFinder;
    ProcessedMessageRepository processedMessageRepository;

    @Autowired
    public MessageProcessorService(ModelMapper modelMapper, PalindromeFinder palindromeFinder, ProcessedMessageRepository processedMessageRepository) {
        this.modelMapper = modelMapper;
        this.palindromeFinder = palindromeFinder;
        this.processedMessageRepository = processedMessageRepository;
    }

    public void saveMessage(Message message) {
        ProcessedMessage processedMessage = modelMapper.map(message, ProcessedMessage.class);
        System.out.println("Processed message : "+ processedMessage.toString());
        System.out.println("Given Message: "+message.toString());
        processedMessage.setLongestPalindromeSize(palindromeFinder.findLongestPalindrome(message.getContent()));
        processedMessageRepository.save(processedMessage);
    }

    public List<ProcessedMessage> findAll() {
        return processedMessageRepository.findAll();
    }
}
