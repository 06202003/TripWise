package com.example.auth;

import com.example.entity.User;

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
        user.setNama("John Doe");
        user.setNik(1234567890);
        user.setAlamat("Jl. Contoh No. 123");
        user.setTanggalLahir("01-01-1990");
        user.setUsername("admin");
        user.setPassword("12345");
        return user;
    }
}
