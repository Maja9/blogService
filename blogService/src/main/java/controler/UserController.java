package controler;

import entity.User;
import lombok.AllArgsConstructor;
import mapper.UserMapper;
import repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.UserDto;

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

 /*   @PostMapping("/login")
    public UserDto loginUser(@RequestBody UserDto userDto) {
       // nie wiem jak zaimplementować tą metodę i jaki ma mieć typ zwracany
    	return null;
    } */


}
