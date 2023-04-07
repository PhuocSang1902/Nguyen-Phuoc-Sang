package com.example.maven.service.impl;

import com.example.maven.dto.UserDto;
import com.example.maven.entity.User;
import com.example.maven.exception.NotFoundException;
import com.example.maven.service.IUserService;
import com.fasterxml.jackson.databind.util.BeanUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.rmi.CORBA.Util;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserService implements IUserService {
    private static ArrayList<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Nguyễn Văn An", "an@gmail.com", "0905123456", "avatar.img","123"));
        users.add(new User(2, "Nguyễn Thị Bình", "binh@gmail.com", "0905123789", "avatar1.img","456"));
        users.add(new User(3, "Phạm Văn Thủy", "thuy@gmail.com", "0905456789", "avatar2.img","789"));
        users.add(new User(4, "Trần Văn Ơn", "on@gmail.com", "0905246803", "avatar3.img","135"));
        users.add(new User(5, "Nguyễn Ánh", "anh@gmail.com", "0905135791", "avatar4.img","246"));
    }

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users){
            userDtos.add(mapUserToUserDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto getUserById(int id) {
        for (User user: users){
            if (user.getId() == id){
                return mapUserToUserDto(user);
            }
        }
        throw new NotFoundException("User is not exist in the system");
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User user: users){
            if (user.getName().contains(keyword)){
                userDtos.add(mapUserToUserDto(user));
            }
        }
        return userDtos;
    }

    public static UserDto mapUserToUserDto(User user){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
