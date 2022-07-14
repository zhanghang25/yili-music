package com.edu.yilimusic.repository;

import com.edu.yilimusic.entity.User;
import com.edu.yilimusic.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {

//    @Autowired
//    UserRepository userRepository ;
//
//    @Test
//    void findByUsername() {
//        User user = new User();
//        user.setUsername("依力");
//        user.setNickname("程序员依力");
//        user.setPassword("908121");
//        user.setGender(Gender.FEMALE);
//        user.setLastLoginIp("127.0.0.1");
//        user.setLastLoginTime(new Date());
//
//        User savedUser = userRepository.save(user);
//
//        User userResult = userRepository.getByUsername("依力");
//        System.out.println(userResult.toString());
//    }
}