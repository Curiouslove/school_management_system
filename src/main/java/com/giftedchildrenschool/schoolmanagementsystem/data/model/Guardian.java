package com.giftedchildrenschool.schoolmanagementsystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long guardianId;

    private String fullName;

    private String phoneNUmber;

    @Email
    @NotNull
    @NotBlank
    private String email;

    private String password;
}
