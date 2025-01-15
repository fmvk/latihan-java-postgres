package com.latihan.service;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author freak a.k.a. Luqman Aziz Budiman
Java Developer
Created on 15/01/2025 20:43
@Last Modified 15/01/2025 20:43
Version 1.0
*/

import com.latihan.model.User;
import com.latihan.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

//SpringIoC
//JavaStream
//Advanced Native SQL Query
//AOP
@Service
public class UserService{

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        System.out.println("Logging sebelum getAllUsers()");
        List<User> user = userRepo.findAll();
        System.out.println("Logging setelah getAllUsers()");
        return user;
    }

    public void saveUser(User user) {
        System.out.println("Logging sebelum saveUser()");
        userRepo.save(user);
        System.out.println("Logging setelah saveUser()");
    }

    public User getUserById(Long id) {
        return userRepo.findById(id);
    }

    public int updateUser(User user) {
        return userRepo.update(user);
    }

    public int deleteUserById(Long id) {
        return userRepo.deleteById(id);
    }

    public List<User> getSortedMaleUser() {
        return userRepo.findAll().stream()
                .filter(user -> "Laki-laki".equalsIgnoreCase(user.getKelamin()))
                .sorted(Comparator.comparing(User::getNama))
                .collect(Collectors.toList());
    }

    public List<User> getSortedFemaleUser() {
        return userRepo.findAll().stream()
                .filter(user -> "Perempuan".equalsIgnoreCase(user.getKelamin()))
                .sorted(Comparator.comparing(User::getNama))
                .collect(Collectors.toList());
    }
}
