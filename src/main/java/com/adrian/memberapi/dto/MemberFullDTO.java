package com.adrian.memberapi.dto;

import java.time.LocalDate;

public class MemberFullDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private AddressFullDTO address;
    private UserCredentialsDTO userCredentials;
    private String email;
    private String phone;
    private LocalDate dateOfBirth;

    public MemberFullDTO(){

    }

    public MemberFullDTO(Long id, String firstName, String lastName, AddressFullDTO address, UserCredentialsDTO userCredentials, String email, String phone, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.userCredentials = userCredentials;
        this.email = email;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressFullDTO getAddress() {
        return address;
    }

    public UserCredentialsDTO getUserCredentials() {
        return userCredentials;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(AddressFullDTO address) {
        this.address = address;
    }

    public void setUserCredentials(UserCredentialsDTO userCredentials) {
        this.userCredentials = userCredentials;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
