package com.blog.blogservice.mapper;

import com.blog.blogservice.dto.CommentDto;
import com.blog.blogservice.entity.Comment;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper extends ConfigurableMapper {

    @Override
    protected void configure(final MapperFactory factory) {
        factory.classMap(Comment.class, CommentDto.class)
                .byDefault()
                .register();
    }
}
