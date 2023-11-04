package com.adrian.memberapi.service;

public interface AuthorizationService {

    boolean canUpdateMember(Long id, String username);
}
