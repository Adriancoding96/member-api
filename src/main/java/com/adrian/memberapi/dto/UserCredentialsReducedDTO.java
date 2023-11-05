package com.adrian.memberapi.dto;

public class UserCredentialsReducedDTO {

    private Long id;
    private String username;

    public UserCredentialsReducedDTO(){

    }
    public UserCredentialsReducedDTO(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
