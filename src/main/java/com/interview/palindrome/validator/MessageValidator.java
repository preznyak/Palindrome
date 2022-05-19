package com.interview.palindrome.validator;

import com.interview.palindrome.model.Message;
import org.springframework.stereotype.Component;

import static com.interview.palindrome.constant.MessageConstants.*;

@Component
public class MessageValidator implements Validator<Message> {

    @Override
    public ValidatorResult validate(Message toValidate) {
        ValidatorResult result = new ValidatorResult(true, OK);
        if (toValidate.getContent() == null || toValidate.getTimestamp() == null) {
            result.setValid(false);
            result.setMessage(CONTENT_AND_TIMESTAMP_SHOULD_NOT_BE_EMPTY);
        }
        return result;
    }
}
