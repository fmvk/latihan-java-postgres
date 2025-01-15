package com.latihan.controller;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author freak a.k.a. Luqman Aziz Budiman
Java Developer
Created on 15/01/2025 20:29
@Last Modified 15/01/2025 20:29
Version 1.0
*/

import com.latihan.model.User;
import com.latihan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//springIoC
//JavaStream
//Advanced Native SQL Query
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody User user) {
        userService.saveUser(user);
        return "User berhasil ditambah";
    }

    @GetMapping
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping
    public String updateUser(@PathVariable Long id, @RequestParam User user) {
        user.setId(id);
        userService.updateUser(user);
        return "User berhasil diubah";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUserById(id);
        return "User berhasil dihapus";
    }

    @GetMapping("/male-sorted")
    public List<User> getMaleUserSorted() {
        return userService.getSortedMaleUser();
    }

    @GetMapping("/female-sorted")
    public List<User> getFemaleUserSorted() {
        return userService.getSortedFemaleUser();
    }
}