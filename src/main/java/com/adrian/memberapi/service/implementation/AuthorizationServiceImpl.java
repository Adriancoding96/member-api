package com.adrian.memberapi.service.implementation;

import com.adrian.memberapi.model.UserCredentials;
import com.adrian.memberapi.repository.UserCredentialsRepository;
import com.adrian.memberapi.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private final UserCredentialsRepository userCredentialsRepository;

    @Autowired
    public AuthorizationServiceImpl(UserCredentialsRepository userCredentialsRepository) {
        this.userCredentialsRepository = userCredentialsRepository;
    }

    @Override
    public boolean canUpdateMember(Long id, String username) {
        UserCredentials userCredentials = userCredentialsRepository.findByUsername(username);
        System.out.println(userCredentials.getUsername());
        if(!Objects.equals(userCredentials.getId(), id)){
            throw new RuntimeException("Unauthorized");
        }

        return true;
    }
}
