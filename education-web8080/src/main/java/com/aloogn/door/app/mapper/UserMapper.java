package com.aloogn.door.app.mapper;

import com.aloogn.door.app.entities.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    public int create(User user);

    public User getUserById(@Param("id")Long id);
}