package com.veltopia.library.services.converters;

import com.veltopia.avro.UserValue;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {

    public UserValue toSchema(com.veltopia.library.entities.User userModel) {
        UserValue userSchema = new UserValue();

        userSchema.setId(userModel.getId());
        userSchema.setName(userModel.getName());
        userSchema.setLastName(userModel.getLastName());
        userSchema.setBirthDate(userModel.getBirthDate().toString());

        return userSchema;
    }
}
