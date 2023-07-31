package com.example.auth;

import com.example.model.User;

import java.time.LocalDate;
import java.util.Date;

public class LoginService {
    public boolean authenticate(String username, String password) {
        // Dalam implementasi yang sebenarnya, Anda akan memverifikasi username dan password
        // dengan database atau sistem autentikasi yang lebih aman.
        // Di sini, kita akan asumsikan bahwa username dan password yang valid adalah "admin" dan "12345".
        return username.equals("admin") && password.equals("12345");
    }

    public User getUserByUsername(String username) {
        // Dalam implementasi sebenarnya, Anda akan mengambil data pengguna dari database berdasarkan username.
        // Di sini, kita akan kembalikan objek User dengan data yang sudah ditentukan.
        User user = new User();
        user.setName("John Doe");
        user.setAddress("Jl. Contoh No. 123");
        user.setTanggalLahir(new Date(1990, 1, 1));
        user.setPhone("+62 895-0764-7137");
        user.setUsername("admin");
        user.setPassword("12345");
        return user;
    }
}
