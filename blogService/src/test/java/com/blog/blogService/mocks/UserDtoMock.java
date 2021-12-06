package com.blog.blogService.mocks;

import com.blog.blogService.dto.UserDto;

public final class UserDtoMock {

    public UserDtoMock() {
    }

    public static UserDto getBasicUserDto() {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setUserName("ABC");
        userDto.setEmail("user@user.pl");
        userDto.setPassword("DEF");
        userDto.setName("GHI");
        userDto.setSurName("JKL");

        return userDto;
    }
}
