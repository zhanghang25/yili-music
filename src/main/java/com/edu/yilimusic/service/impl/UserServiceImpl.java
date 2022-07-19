package com.edu.yilimusic.service.impl;

import com.edu.yilimusic.dto.UserCreateDto;
import com.edu.yilimusic.dto.UserDto;
import com.edu.yilimusic.entity.User;
import com.edu.yilimusic.exception.BizException;
import com.edu.yilimusic.exception.ExceptionType;
import com.edu.yilimusic.mapper.UserMapper;
import com.edu.yilimusic.repository.UserRepository;
import com.edu.yilimusic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    UserRepository repository;

    UserMapper mapper;

    PasswordEncoder passwordEncoder;

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

    @Override
    public UserDto create(UserCreateDto userCreateDto) {
        checkUserName(userCreateDto.getUsername());
        User user = mapper.createEntity(userCreateDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return mapper.toDto(repository.save(user));
    }

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    private void checkUserName(String username) {
        Optional<User> user = repository.findByUsername(username);
        if (user.isPresent()) {
            throw new BizException(ExceptionType.USER_NAME_DUPLICATE);
        }
    }

    @Autowired
    public void setRepository(UserRepository repository) {
        this.repository = repository;
    }

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = repository.findByUsername(s);
        if(!user.isPresent()){
            throw new BizException(ExceptionType.USER_NOT_FOUND);
        }

        return user.get();
    }
}
