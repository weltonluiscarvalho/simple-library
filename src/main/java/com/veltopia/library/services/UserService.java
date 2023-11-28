package com.veltopia.library.services;

import com.veltopia.avro.UserValue;
import com.veltopia.library.entities.User;
import com.veltopia.library.kafka.UserProducer;
import com.veltopia.library.repositories.UserRepository;
import com.veltopia.library.services.converters.UserConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserProducer userProducer;

    @Autowired
    UserConverter userConverter;

    @Autowired
    private UserRepository userRepository;

    public void searchUserById(Long id) {
        logger.info("Searching user by Id {}", id);

        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()) {
            logger.info("User not found");
            return;
        }

        user.ifPresent(value -> logger.info("User found: {}", value));

        UserValue userSchema = userConverter.toSchema(user.get());
        userProducer.sendMessage(userSchema);
    }
}
