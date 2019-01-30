package com.users.dao;

import com.users.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("SELECT * FROM users")
    List<User> getAllUsers();

    @Select("SELECT * FROM users WHERE id = #{id}")
    public User getUserById(int id);

    @Delete("DELETE FROM users WHERE id = #{id}")
    public int deleteUserById(int id);

    @Insert("INSERT into users (id,firstName,lastName,role) " +
            "VALUES (#{id}, #{firstName}, #{lastName}, #{role})")
    int createUser(User user);

    @Update("UPDATE users SET firstName = #{firstName}, lastName = #{lastName}," +
            " role = #{role} WHERE id = #{id}")
    int updateUserById(User user);
}
