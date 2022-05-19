package com.interview.palindrome.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name="ProcessedMessage")
public class ProcessedMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;
    private String content;
    private LocalDateTime timestamp;
    private Integer longestPalindromeSize;

    public ProcessedMessage() {
    }

    public ProcessedMessage(String content, LocalDateTime timestamp, Integer longestPalindromeSize) {
        this.content = content;
        this.timestamp = timestamp;
        this.longestPalindromeSize = longestPalindromeSize;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getLongestPalindromeSize() {
        return longestPalindromeSize;
    }

    public void setLongestPalindromeSize(Integer longestPalindromeSize) {
        this.longestPalindromeSize = longestPalindromeSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProcessedMessage that = (ProcessedMessage) o;
        return Objects.equals(content, that.content) && Objects.equals(timestamp, that.timestamp) && Objects.equals(longestPalindromeSize, that.longestPalindromeSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, timestamp, longestPalindromeSize);
    }

    @Override
    public String toString() {
        return "ProcessedMessage{" +
                "messageId=" + messageId +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", longestPalindromeSize=" + longestPalindromeSize +
                '}';
    }
}
