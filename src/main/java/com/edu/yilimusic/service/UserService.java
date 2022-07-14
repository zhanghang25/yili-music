package com.edu.yilimusic.service;

import com.edu.yilimusic.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<UserDto> list();
}
