package com.blog.blogService.controler;

import com.blog.blogService.dto.UserDto;
import com.blog.blogService.service.spi.UserService;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class UserController {

    private final UserService userService;


    @PostMapping("/users")
    public Long createUser(@RequestBody @Validated final UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable("id") final Long userId) {
        return userService.getUser(userId);
    }

    @PutMapping("/users/{id}")
    public UserDto editUser(@RequestBody @Validated(UserDto.UpdateUser.class) final UserDto userDto,
                            @PathVariable("id") final Long userId) {
        if (userId.equals(userDto.getId())) {
            userService.createUser(userDto);
            return userService.getUser(userId);
        }
        return null;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@RequestBody @Validated(UserDto.DeleteUser.class) final UserDto userDto,
                           @PathVariable("id") Long userId) {
        userService.deleteUser(userDto.getId(), userDto.getPassword());
    }

    @PostMapping("users/password")
    public void sendNewPassword(@RequestBody @Validated(UserDto.SendNewPassword.class) final UserDto userDto) {
        userService.resetPassword(userDto.getEmail());
    }

}
