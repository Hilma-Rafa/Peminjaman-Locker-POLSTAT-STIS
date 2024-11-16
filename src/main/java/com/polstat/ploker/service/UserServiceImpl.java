package com.polstat.ploker.service;

import com.polstat.ploker.dto.UserDto;
import com.polstat.ploker.entity.User;
import com.polstat.ploker.repository.UserRepository;
import com.polstat.ploker.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    // Constructor injection untuk UserRepository
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto); // Convert UserDto to User
        user = userRepository.save(user); // Simpan user ke database
        return UserMapper.mapToUserDto(user); // Convert User kembali ke UserDto
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email); // Temukan user berdasarkan email
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        return UserMapper.mapToUserDto(user); // Convert User ke UserDto
    }
}