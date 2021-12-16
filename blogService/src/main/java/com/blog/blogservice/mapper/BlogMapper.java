package com.blog.blogservice.mapper;

import com.blog.blogservice.dto.BlogDto;
import com.blog.blogservice.entity.Blog;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper extends ConfigurableMapper {


    @Override
    protected void configure(final MapperFactory factory) {
        factory.classMap(Blog.class, BlogDto.class)
                .field("author.username", "author.userName")
                .byDefault()
                .register();

    }

}
