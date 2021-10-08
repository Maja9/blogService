package com.blog.blogService.Mapper;

import com.blog.blogService.dto.UserDto;
import com.blog.blogService.entity.User;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserMapper extends ConfigurableMapper {

    protected void configure(MapperFactory factory) {
        factory.classMap(User.class, UserDto.class)
                .field("name", "surname")
                .byDefault()
                .register();

    }

}
