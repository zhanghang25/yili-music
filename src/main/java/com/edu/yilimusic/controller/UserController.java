package com.edu.yilimusic.controller;

import com.edu.yilimusic.dto.UserDto;
import com.edu.yilimusic.mapper.UserMapper;
import com.edu.yilimusic.service.UserService;
import com.edu.yilimusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/")
    List<UserVo> list(){
        List<UserDto> list = userService.list();
        Stream<UserDto> stream = list.stream();
        Stream<UserVo> userVoStream = stream.map(userMapper::toVo);
        List<UserVo> collect = userVoStream.collect(Collectors.toList());
        return collect;
    }
}
