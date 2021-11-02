package blogService.service;

import blogService.dto.UserDto;
import blogService.entity.User;
import blogService.mapper.UserMapper;
import blogService.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public Long createUser(UserDto userDto) {
        User userToSave = userMapper.map(userDto, User.class);
        if (userDto.getPassword() != null){
        userToSave.setPassHash(userDto.getPassword().hashCode());
        }
        return userRepository.save(userToSave)
                .getId();

    }

    public UserDto getUser(Long userId) {
        Optional<User> optional = userRepository.findById(userId);
        if (optional.isPresent()) {
            UserDto user = userMapper.map(optional.get(), UserDto.class);
            return user;
        }
        return null;
    }

    public String deleteUser(Long userId, String password) {
        if (password.hashCode() == userRepository.findById(userId).get().getPassHash()){
            userRepository.deleteById(userId);
            return "The user has been deleted.";
        }
        return "The user has not been deleted.";
    }
}
