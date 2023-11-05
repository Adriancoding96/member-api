package com.adrian.memberapi.mapper;

import com.adrian.memberapi.dto.UserCredentialsFullDTO;
import com.adrian.memberapi.model.UserCredentials;
import org.springframework.stereotype.Component;

@Component
public class UserCredentialsMapper {

    public UserCredentials toEntity(UserCredentialsFullDTO userCredentialsDTO){
        UserCredentials userCredentials = new UserCredentials();
        if(userCredentialsDTO.getId() != null){
            userCredentials.setId(userCredentialsDTO.getId());
        }
        userCredentials.setUsername(userCredentialsDTO.getUsername());
        userCredentials.setPassword(userCredentialsDTO.getPassword());
        userCredentials.setRole(userCredentialsDTO.getRole());
        return userCredentials;
    }

}
