package com.edu.yilimusic.service;

import com.edu.yilimusic.dto.UserCreateDto;
import com.edu.yilimusic.dto.UserDto;
import com.edu.yilimusic.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;


public interface UserService extends UserDetailsService {
    List<UserDto> list();

    UserDto create(UserCreateDto userCreateDto);

    @Override
    User loadUserByUsername(String s);
}
