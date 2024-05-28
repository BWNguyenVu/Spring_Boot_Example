package com.example.crud.services;

import com.example.crud.dto.requests.UserCreateRequest;
import com.example.crud.entities.UserEntity;
import com.example.crud.exeptions.ErrorCode;
import com.example.crud.exeptions.UserAppException;
import com.example.crud.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserCreateRequest request) {
        UserEntity user = new UserEntity();

        if (userRepository.existsByUsername(request.getUsername()))
            throw new UserAppException(ErrorCode.USER_EXISTED);

        user.setUsername(request.getUsername());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(request.getPassword());
        user.setBirthDate(request.getBirthDate());
//        logger.info("Creating UserEntity: {}", user);

        return userRepository.save(user);
    }

    public UserEntity getUserById(Integer userId) {
        return  userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
