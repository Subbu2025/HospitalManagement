package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
public class Login {

    @Id
    private String username; // primary key

    private String password;

    private String role;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private SomeOtherEntity id; // foreign key relationship

    // Default constructor
    public Login() {}

    // Parameterized constructor
    public Login(String username, String password, String role, SomeOtherEntity id) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.id = id;
    }

    // Getters and Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public SomeOtherEntity getId() {
        return id;
    }

    public void setId(SomeOtherEntity id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Login [username=" + username + ", password=" + password + ", role=" + role + ", id=" + id + "]";
    }
}
