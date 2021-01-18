package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private String id;
    private String userName;
    private String password;
    private LocalDateTime createTime;
}
