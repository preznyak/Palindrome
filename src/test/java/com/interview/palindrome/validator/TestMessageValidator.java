package com.interview.palindrome.validator;

import com.interview.palindrome.constant.MessageConstants;
import com.interview.palindrome.model.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

public class TestMessageValidator {

    private static final String VALID_CONTENT = "TestContent";
    private static final String INVALID_CONTENT = "12354Invalid";
    private static final OffsetDateTime TEST_DATE_TIME = OffsetDateTime.now();

    MessageValidator messageValidator = new MessageValidator();

    @Test
    public void testMessageValidator_ShouldReturnValid() {
        Message testMessage = new Message(VALID_CONTENT, TEST_DATE_TIME);
        ValidatorResult validatorResult = messageValidator.validate(testMessage);
        Assertions.assertTrue(validatorResult.isValid());
        Assertions.assertEquals(MessageConstants.OK, validatorResult.getMessage());
    }

    @Test
    public void testMessageValidator_ShouldReturnInvalidContentIsNull() {
        Message testMessage = new Message(null, TEST_DATE_TIME);
        ValidatorResult validatorResult = messageValidator.validate(testMessage);
        Assertions.assertFalse(validatorResult.isValid());
        Assertions.assertEquals(MessageConstants.CONTENT_AND_TIMESTAMP_SHOULD_NOT_BE_EMPTY, validatorResult.getMessage());
    }

    @Test
    public void testMessageValidator_ShouldReturnInvalidTimestampIsNull() {
        Message testMessage = new Message(VALID_CONTENT, null);
        ValidatorResult validatorResult = messageValidator.validate(testMessage);
        Assertions.assertFalse(validatorResult.isValid());
        Assertions.assertEquals(MessageConstants.CONTENT_AND_TIMESTAMP_SHOULD_NOT_BE_EMPTY, validatorResult.getMessage());
    }

    @Test
    public void testMessageValidator_ShouldReturnInvalidContentAndTimestampIsNull() {
        Message testMessage = new Message(null, null);
        ValidatorResult validatorResult = messageValidator.validate(testMessage);
        Assertions.assertFalse(validatorResult.isValid());
        Assertions.assertEquals(MessageConstants.CONTENT_AND_TIMESTAMP_SHOULD_NOT_BE_EMPTY, validatorResult.getMessage());
    }

    @Test
    public void testMessageValidator_ShouldReturnInvalidInvalidContent() {
        Message testMessage = new Message(INVALID_CONTENT, TEST_DATE_TIME);
        ValidatorResult validatorResult = messageValidator.validate(testMessage);
        Assertions.assertFalse(validatorResult.isValid());
        Assertions.assertEquals(MessageConstants.INVALID_CONTENT, validatorResult.getMessage());
    }
}
