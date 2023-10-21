package com.ms.user.service;

import com.ms.user.model.User;
import com.ms.user.model.dto.UserDto;
import com.ms.user.producer.UserProducer;
import com.ms.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserProducer userProducer;

    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public User create(UserDto dto) {
        User user = new User();
        copyProperties(dto, user);
        userProducer.publishMessageEmail(user);
        return userRepository.save(user);
    }
}
