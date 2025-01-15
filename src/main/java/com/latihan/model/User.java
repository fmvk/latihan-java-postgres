package com.latihan.model;


/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author freak a.k.a. Luqman Aziz Budiman
Java Developer
Created on 15/01/2025 20:57
@Last Modified 15/01/2025 20:57
Version 1.0
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String nama;
    private String email;
    private String password;
    private String kelamin;
    private String nik;
}
