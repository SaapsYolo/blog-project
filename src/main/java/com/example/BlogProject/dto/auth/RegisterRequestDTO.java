package com.example.BlogProject.dto.auth;

public class RegisterRequestDTO {
    private String username;
    private String password;

    public RegisterRequestDTO() {
    }
    // getters and setters

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
}
