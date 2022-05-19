package com.interview.palindrome.validator;

public interface Validator<T> {
    ValidatorResult validate(T toValidate);
}
