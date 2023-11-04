package com.adrian.memberapi.model;

import jakarta.persistence.*;
import com.adrian.memberapi.enums.Role;


@Entity
@Table(name = "user_credentials")
public class UserCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
    @OneToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    public UserCredentials(){

    }

    public UserCredentials(Long id, String username, String password, Role role, Member member) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.member = member;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }

    public Member getMember() {
        return member;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
