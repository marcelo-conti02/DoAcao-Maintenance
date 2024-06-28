package com.ages.doacaobackend.controller;

import com.ages.doacaobackend.business.dto.User.LoginRequest;
import com.ages.doacaobackend.business.dto.User.UserResponse;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.MalformedEntityException;
import com.ages.doacaobackend.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) throws EntityNotFoundException, MalformedEntityException {
        return new ResponseEntity<UserResponse>(userService.login(loginRequest), HttpStatus.OK);
    }
}
