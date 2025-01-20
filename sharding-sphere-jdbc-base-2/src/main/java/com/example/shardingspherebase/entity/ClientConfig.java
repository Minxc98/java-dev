package com.example.shardingspherebase.entity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class ClientConfig {
    // Getters and Setters
    private Long id;
    private Long clientId;
    private String dsName;

}