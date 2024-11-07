package com.colak.springtutorial.validation;

import com.colak.springtutorial.dto.UserRegisterRequest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@UserRegisterValidationRegistration(order = 3)
@AllArgsConstructor
public class UserRegisterPasswordValidator implements IUserRegisterRequestValidation {
    private static final String PASSWORD_FIELD = "email";
    private static final String PASSWORD_NOT_STRONG = "Password does not follow the Expected Pattern";

    @Override
    public boolean validate(UserRegisterRequest registerRequest, Errors errors) {
        if (errors.hasErrors()) {
            return false;
        }
        if (!isValidPattern(registerRequest.getPassword())) {
            errors.rejectValue(PASSWORD_FIELD, HttpStatus.BAD_REQUEST.name(), PASSWORD_NOT_STRONG);
            return false;
        }
        return true;
    }

    private boolean isValidPattern(String password) {
        return false;
    }

}
