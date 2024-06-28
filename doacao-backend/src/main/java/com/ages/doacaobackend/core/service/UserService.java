package com.ages.doacaobackend.core.service;

import com.ages.doacaobackend.business.dto.User.LoginRequest;
import com.ages.doacaobackend.business.dto.User.UserRequest;
import com.ages.doacaobackend.business.dto.User.UserResponse;
import com.ages.doacaobackend.business.entity.User;
import com.ages.doacaobackend.business.exception.EntityNotFoundException;
import com.ages.doacaobackend.business.exception.MalformedEntityException;
import com.ages.doacaobackend.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import static com.ages.doacaobackend.business.validation.FieldValidator.validateFields;

@Service
public class UserService {

    @Autowired
    @Lazy
    UserRepository userRepository;

    public UserResponse login(LoginRequest request) throws EntityNotFoundException, MalformedEntityException {
        validateFields(request);
        return userRepository.login(request);
    }

    public User createUser(UserRequest user) throws EntityNotFoundException, MalformedEntityException {
        validateFields(user);
        return userRepository.createUser(user);
    }
}
