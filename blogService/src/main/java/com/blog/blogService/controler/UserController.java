package com.blog.blogService.controler;

import com.blog.blogService.Mapper.UserMapper;
import com.blog.blogService.dto.UserDto;
import com.blog.blogService.entity.User;
import com.blog.blogService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @PostMapping("/users")
    public Long createUser(@RequestBody UserDto userDto){
        User userToSave = userMapper.map(userDto, User.class);
        return userRepository.save(userToSave)
                .getId();
    }
}
