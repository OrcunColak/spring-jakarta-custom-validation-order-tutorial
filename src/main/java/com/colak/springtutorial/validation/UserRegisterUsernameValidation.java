package com.colak.springtutorial.validation;

import com.colak.springtutorial.dto.UserRegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@UserRegisterValidationRegistration(order = 1)
@Component
@AllArgsConstructor
public class UserRegisterUsernameValidation implements IUserRegisterRequestValidation {
    private static final String USERNAME_FIELD = "username";
    private static final String USERNAME_ALREADY_TAKEN = "Username already taken";
    private static final String USERNAME_PATTERN_NOT_MATCH = "Username pattern is not valid";

    @Override
    public boolean validate(UserRegisterRequest registerRequest, Errors errors) {
        if (errors.hasErrors()) {
            return false;
        }
        if (isUsernameAlreadyTaken(registerRequest.getUsername())) {
            errors.rejectValue(USERNAME_FIELD, HttpStatus.BAD_REQUEST.name(), USERNAME_ALREADY_TAKEN);
            return false;
        }
        if (!isPatternMatches(registerRequest.getUsername())) {
            errors.rejectValue(USERNAME_FIELD, HttpStatus.BAD_REQUEST.name(), USERNAME_PATTERN_NOT_MATCH);
            return false;
        }
        return true;
    }

    private boolean isPatternMatches(String username) {
        return false;
    }

    private boolean isUsernameAlreadyTaken(String username) {
        return false;
    }
}
