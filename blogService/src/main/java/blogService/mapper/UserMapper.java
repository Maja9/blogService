package blogService.mapper;

import blogService.entity.User;
import blogService.dto.UserDto;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;


@Component
public class UserMapper extends ConfigurableMapper {
	

    protected void configure(MapperFactory factory) {
        factory.classMap(User.class, UserDto.class)
                .field("username", "userName")
                .byDefault()
                .register();

    }

}
