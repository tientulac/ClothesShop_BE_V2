package com.example.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInfo {
    private int account_id;
    private String user_name;
    private boolean admin;
    private boolean active;
    private String address;
    private String avatar;
    private String phone;
    private String full_name;
    private String email;
    private String token;
    private String role_code;
}
