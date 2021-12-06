package com.blog.blogService.mapper;

import com.blog.blogService.dto.UserDto;
import com.blog.blogService.entity.User;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;


@Component
public class UserMapper extends ConfigurableMapper {
	

    protected void configure(final MapperFactory factory) {
        factory.classMap(User.class, UserDto.class)
                .field("username", "userName")
                .byDefault()
                .register();

    }

}
