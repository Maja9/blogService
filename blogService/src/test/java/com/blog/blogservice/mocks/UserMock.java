package com.blog.blogservice.mocks;

import com.blog.blogservice.entity.User;

import java.util.HashSet;

public final class UserMock {

    private UserMock() {
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

    public static User getAnotherUser() {
        User user = new User();
        user.setId(2L);
        user.setUsername("ZXC");
        user.setEmail("zxc@email.pl");
        user.setName("ZXC");
        user.setSurName("JKL");
        user.setPassHash(456);
        user.setBlogs(new HashSet<>());

        return user;
    }
}
