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
        processedMessage.setLongestPalindromeSize(palindromeFinder.findLongestPalindrome(processedMessage.getContent()));
        processedMessageRepository.save(processedMessage);
    }

    public List<ProcessedMessage> findAll() {
        return processedMessageRepository.findAll();
    }
}
