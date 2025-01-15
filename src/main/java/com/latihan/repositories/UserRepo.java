package com.latihan.repositories;

/*
IntelliJ IDEA 2022.3.1 (Community Edition)
Build #IC-243.22562.218, built on December 18, 2024
@Author freak a.k.a. Luqman Aziz Budiman
Java Developer
Created on 15/01/2025 20:54
@Last Modified 15/01/2025 20:54
Version 1.0
*/

import com.latihan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//SpringIoC
//Advanced Native SQL Query
@Repository
public class UserRepo {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int save(User user) {
        String sql = "INSERT INTO users (nama, email, password, kelamin, nik) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getNama(), user.getEmail(), user.getPassword(), user.getKelamin(), user.getNik());
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("kelamin"),
                        rs.getString("nik")
                )
        );
    }

    public User findById(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new User(
                        rs.getLong("id"),
                        rs.getString("nama"),
                        rs.getString("email"),
                        rs.getString("password"),
                        rs.getString("kelamin"),
                        rs.getString("nik")
                ), id);
    }

    public int update(User user) {
        String sql = "UPDATE users SET nama = ?, email = ?, password = ?, kelamin = ?, nik = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getNama(), user.getEmail(), user.getPassword(), user.getKelamin(), user.getNik(), user.getId());
    }

    public int deleteById(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
