package com.mmtk.manga.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uid;
    private String email;
    private String password;
    private Role role;
    private long joinedDate;

    public User() {
    }

    public User(Long uid, String email, String password, Role role, long joinedDate) {
        this.uid = uid;
        this.email = email;
        this.password = password;
        this.role = role;
        this.joinedDate = joinedDate;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public long getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(long uploadDate) {
        this.joinedDate = joinedDate;
    }
}
