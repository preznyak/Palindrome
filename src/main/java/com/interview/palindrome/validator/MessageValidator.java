package com.interview.palindrome.validator;

import com.interview.palindrome.model.Message;
import org.springframework.stereotype.Component;

import static com.interview.palindrome.constant.MessageConstants.*;

@Component
public class MessageValidator implements Validator<Message> {

    /**
     * <p>This method is used for user input validation.
     * If the input does not meet the conditions, the method sends
     * back a ValidatorResult object which contains the information about
     * the input's invalidity.
     * The input should not contain null values.
     * The content inside the input should contain only letters.</p>
     * @param toValidate the user's input object
     * @return the validator result
     */
    @Override
    public ValidatorResult validate(Message toValidate) {
        ValidatorResult result = new ValidatorResult(true, OK);
        if (toValidate.getContent() == null || toValidate.getTimestamp() == null) {
            result.setValid(false);
            result.setMessage(CONTENT_AND_TIMESTAMP_SHOULD_NOT_BE_EMPTY);
            return result;
        }
        if (!toValidate.getContent().matches("[a-zA-Z]+")) {
            result.setValid(false);
            result.setMessage(INVALID_CONTENT);
        }
        return result;
    }
}
