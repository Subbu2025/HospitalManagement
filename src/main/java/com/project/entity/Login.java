package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Login {

    @Id
    private String username; // primary key

    private String id; // regular field
    private String password;
    private String role;

    // Default constructor
    public Login() {}

    // Parameterized constructor
    public Login(String username, String id, String password, String role) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Login [username=" + username + ", id=" + id + ", password=" + password + ", role=" + role + "]";
    }
}
