package com.blog.blogservice.service.spi;

import com.blog.blogservice.dto.UserDto;

public interface UserService {

    Long createUser(UserDto userDto);

    UserDto getUser(Long userId);

    String deleteUser(Long userId, String password);

    String resetPassword(String email);

}
