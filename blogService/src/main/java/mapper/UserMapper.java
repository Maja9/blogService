package mapper;

import entity.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import dto.UserDto;

import java.util.Map;

@Component
public class UserMapper extends ConfigurableMapper {
	
	

    protected void configure(MapperFactory factory) {
        factory.classMap(User.class, UserDto.class)
                .field("username", "userName")
                .byDefault()
                .register();

    }

}
