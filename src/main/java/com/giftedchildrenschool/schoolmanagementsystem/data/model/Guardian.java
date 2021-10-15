package com.giftedchildrenschool.schoolmanagementsystem.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    private String email;

    private String password;
}
