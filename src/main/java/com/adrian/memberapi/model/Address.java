package com.adrian.memberapi.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;

    //Anvöäd set istället för list för att förhindra att samma member mappas till samma address mer en en gång
    @OneToMany(mappedBy = "address", fetch = FetchType.LAZY)
    private Set<Member> members = new HashSet<>();

    public Address() {
    }

    public Address(String street, String postalCode, String city) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
    }

    public Address(String street, String postalCode, String city, Set<Member> members) {
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.members = members;
    }

    public Address(Long id, String street, String postalCode, String city, Set<Member> members) {
        this.id = id;
        this.street = street;
        this.postalCode = postalCode;
        this.city = city;
        this.members = members;
    }

    public Long getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public Set<Member> getMembers() {
        return members;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }
}
