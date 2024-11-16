package com.polstat.ploker.mapper;

import com.polstat.ploker.dto.UserDto;
import com.polstat.ploker.entity.User;

public class UserMapper {

    // Metode untuk mengonversi User ke UserDto
    public static UserDto mapToUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(user.getPassword()) // Pastikan tidak mengirimkan password jika tidak diperlukan
                .build();
    }

    // Metode untuk mengonversi UserDto ke User
    public static User mapToUser(UserDto userDto) {
        return User.builder()
                .id(userDto.getId())
                .email(userDto.getEmail())
                .password(userDto.getPassword()) // Pastikan password dikelola dengan aman
                .build();
    }
}