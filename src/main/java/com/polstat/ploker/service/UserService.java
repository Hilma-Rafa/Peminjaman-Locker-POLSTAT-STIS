package com.polstat.ploker.service;

import com.polstat.ploker.dto.UserDto;

public interface UserService {

    // Deklarasi metode untuk membuat user
    UserDto createUser(UserDto user);

    // Deklarasi metode untuk mendapatkan user berdasarkan email
    UserDto getUserByEmail(String email);
}