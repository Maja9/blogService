package com.blog.blogservice.mapper;

import com.blog.blogservice.dto.UserDto;
import com.blog.blogservice.entity.User;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;


@Component
public class UserMapper extends ConfigurableMapper {


    @Override
    protected void configure(final MapperFactory factory) {
        factory.classMap(User.class, UserDto.class)
                .field("username", "userName")
                .byDefault()
                .register();

    }

}
