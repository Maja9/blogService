package com.blog.blogservice.mocks;

import com.blog.blogservice.dto.UserDto;

public final class UserDtoMock {

    private UserDtoMock() {
    }

    public static UserDto getBasicUserDto() {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setUserName("ABC");
        userDto.setEmail("email@email.pl");
        userDto.setPassword("DEF");
        userDto.setName("DEF");
        userDto.setSurName("GHI");

        return userDto;
    }

    public static UserDto getAnotherUserDto() {
        UserDto userDto = new UserDto();
        userDto.setId(2L);
        userDto.setUserName("ABC");
        userDto.setEmail("email@email.pl");
        userDto.setPassword("DEF");
        userDto.setName("DEF");
        userDto.setSurName("GHI");

        return userDto;
    }
}
