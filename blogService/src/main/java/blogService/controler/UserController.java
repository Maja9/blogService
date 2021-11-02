package blogService.controler;

import blogService.entity.User;
import blogService.service.UserService;
import lombok.AllArgsConstructor;
import blogService.mapper.UserMapper;
import blogService.repository.UserRepository;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import blogService.dto.UserDto;

import javax.persistence.Access;
import javax.persistence.Column;
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

    @PutMapping("/users/{id}")
    public UserDto editUser(@RequestBody @Validated(UserDto.UpdateUser.class) UserDto userDto,
                            @PathVariable("id") Long userId) {
        if (userId.equals(userDto.getId())) {
            userService.createUser(userDto);
            return userService.getUser(userId);
        }
        return null;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@RequestBody @Validated(UserDto.DeleteUser.class) UserDto userDto,
                           @PathVariable("id") Long userId) {
        userService.deleteUser(userDto.getId(),userDto.getPassword());
    }

}
