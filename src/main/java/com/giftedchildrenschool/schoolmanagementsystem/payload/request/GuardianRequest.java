package com.giftedchildrenschool.schoolmanagementsystem.payload.request;

import lombok.Data;

@Data
public class GuardianRequest {
    private String fullName;

    private String phoneNUmber;

    private String email;

    private String password;
}
