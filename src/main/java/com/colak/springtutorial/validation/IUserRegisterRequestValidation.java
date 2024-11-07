package com.colak.springtutorial.validation;

import com.colak.springtutorial.dto.UserRegisterRequest;
import org.springframework.validation.Errors;

@FunctionalInterface
public interface IUserRegisterRequestValidation {
    boolean validate(UserRegisterRequest registerRequest, Errors errors);
}
