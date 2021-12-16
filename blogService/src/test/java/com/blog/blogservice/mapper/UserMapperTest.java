package com.blog.blogservice.mapper;

import com.blog.blogservice.dto.UserDto;
import com.blog.blogservice.entity.Blog;
import com.blog.blogservice.entity.User;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

public class UserMapperTest {



    @Test
    public void shouldMapUserToUserDto() {

        //given
        User user = new User(1L, "username", "email", 123, "name", "surname", new HashSet<Blog>());
        UserMapper userMapper = new UserMapper();

        //when
        final UserDto userDto = userMapper.map(user, UserDto.class);

        //then
        Assert.assertEquals(user.getId(), userDto.getId());
        Assert.assertEquals(user.getUsername(), userDto.getUserName());
        Assert.assertEquals(user.getEmail(), userDto.getEmail());
        Assert.assertEquals(user.getName(), userDto.getName());
        Assert.assertEquals(user.getSurName(), userDto.getSurName());


    }

    @Test
    public void shouldMapUserDToToUser() {

        //given
        UserDto userDto = new UserDto(2L, "username2", "email2", "password", "name2", "surname2");
        UserMapper userMapper = new UserMapper();

        //when
        final User user = userMapper.map(userDto, User.class);

        //then
        Assert.assertEquals(userDto.getId(), user.getId());
        Assert.assertEquals(userDto.getUserName(), user.getUsername());
        Assert.assertEquals(userDto.getEmail(), user.getEmail());
        Assert.assertEquals(userDto.getName(), user.getName());
        Assert.assertEquals(userDto.getSurName(), user.getSurName());


    }
}
