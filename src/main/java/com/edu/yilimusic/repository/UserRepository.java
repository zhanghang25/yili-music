package com.edu.yilimusic.repository;

import com.edu.yilimusic.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    User getByUsername(String username);

    Optional<User> findByUsername(String username);

}
