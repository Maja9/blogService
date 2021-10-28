package blogService.controler;

import blogService.entity.User;
import blogService.service.UserService;
import lombok.AllArgsConstructor;
import blogService.mapper.UserMapper;
import blogService.repository.UserRepository;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import blogService.dto.UserDto;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;


    @PostMapping("/users")
    public Long createUser(@RequestBody @Validated UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/users/{id}")
    public UserDto getUser(@PathVariable("id") Long userId) {
        return userService.getUser(userId);
    }





}
