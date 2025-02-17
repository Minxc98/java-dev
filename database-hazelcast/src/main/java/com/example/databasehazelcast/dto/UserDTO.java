package com.example.databasehazelcast.dto;

public class UserDTO {
    private String name;
    private String userId;

    public UserDTO() {
    }

    public UserDTO(String name, String userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
