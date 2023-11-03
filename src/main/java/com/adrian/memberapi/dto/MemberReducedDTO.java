package com.adrian.memberapi.dto;

public class MemberReducedDTO {

    private String firstName;
    private String lastName;
    private AddressReducedDTO address;
    private String email;
    private String phone;

    public MemberReducedDTO(){

    }

    public MemberReducedDTO(String firstName, String lastName, AddressReducedDTO address, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AddressReducedDTO getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(AddressReducedDTO address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
