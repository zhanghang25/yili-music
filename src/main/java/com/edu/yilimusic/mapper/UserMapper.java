package com.edu.yilimusic.mapper;

import com.edu.yilimusic.dto.UserCreateDto;
import com.edu.yilimusic.dto.UserDto;
import com.edu.yilimusic.entity.User;
import com.edu.yilimusic.vo.UserVo;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserDto toDto(User user);

    UserVo toVo(UserDto userDto);

    User createEntity(UserCreateDto userCreateDto);


}
