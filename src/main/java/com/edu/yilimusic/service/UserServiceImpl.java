package com.edu.yilimusic.service;

import com.edu.yilimusic.dto.UserDto;
import com.edu.yilimusic.entity.User;
import com.edu.yilimusic.mapper.UserMapper;
import com.edu.yilimusic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    UserMapper mapper;

    @Autowired
    public void setMapper(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<UserDto> list() {
        List<User> all = repository.findAll();
        Stream<User> stream = all.stream();
        Stream<UserDto> userDtoStream = stream.map(mapper::toDto);
        return userDtoStream.collect(Collectors.toList());
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }
}
