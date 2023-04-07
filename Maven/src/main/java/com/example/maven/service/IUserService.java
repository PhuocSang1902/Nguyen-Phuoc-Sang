package com.example.maven.service;

import com.example.maven.dto.UserDto;
import com.example.maven.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IUserService {
    List<UserDto> getListUser();

    UserDto getUserById(int id);

    List<UserDto> searchUser(String keyword);
}
