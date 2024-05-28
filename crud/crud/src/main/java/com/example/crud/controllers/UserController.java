package com.example.crud.controllers;

import com.example.crud.dto.requests.ApiResponse;
import com.example.crud.dto.requests.UserCreateRequest;
import com.example.crud.entities.UserEntity;
import com.example.crud.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ApiResponse<UserEntity> createUser(@RequestBody @Valid UserCreateRequest request) {
//        logger.info("Received UserCreateRequest: {}", request);
        ApiResponse<UserEntity> apiResponse = new ApiResponse<>();
        apiResponse.setData(userService.createUser(request));
        return apiResponse;
    }

    @GetMapping("/{userId}")
    public UserEntity getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }
}
