package com.blog.blogService.mocks;

import com.blog.blogService.entity.User;

import java.util.HashSet;

public final class UserMock {

    public UserMock() {
    }

    public static User getBasicUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("ABC");
        user.setEmail("email@email.pl");
        user.setName("DEF");
        user.setSurName("GHI");
        user.setPassHash(123);
        user.setBlogs(new HashSet<>());

        return user;
    }

}
