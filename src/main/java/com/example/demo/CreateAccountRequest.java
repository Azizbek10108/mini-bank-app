package com.example.demo;

import lombok.Data;

// CreateRequest DTO yarat:
@Data
public class CreateAccountRequest {
    private String fullname;
    private String pinCode;
    private String phone;
}