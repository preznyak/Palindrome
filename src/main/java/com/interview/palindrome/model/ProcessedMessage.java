package com.interview.palindrome.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.OffsetDateTimeSerializer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.OffsetDateTime;
import java.util.Objects;

@Entity(name="ProcessedMessage")
public class ProcessedMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageId;
    private String content;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime timestamp;
    private Integer longestPalindromeSize;

    public ProcessedMessage() {
    }

    public ProcessedMessage(String content, OffsetDateTime timestamp, Integer longestPalindromeSize) {
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

    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
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
