package com.colak.springtutorial.controller;

import com.colak.springtutorial.dto.UserRegisterRequest;
import com.colak.springtutorial.validation.UserRegisterRequestValidator;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserRegisterController {
    private UserRegisterRequestValidator userRegisterRequestValidator;

    @InitBinder("userRegisterRequest")
    protected void initBinderForUserRegisterRequest(WebDataBinder binder) {
        binder.addValidators(userRegisterRequestValidator);
    }

    @Validated
    @PostMapping("/register")
    public ResponseEntity<Object> register(@Valid @RequestBody UserRegisterRequest userRegisterRequest) {
        return ResponseEntity.ok(userRegisterRequest.toString());
    }
}
