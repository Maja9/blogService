package com.blog.blogService.mapper;

import com.blog.blogService.dto.BlogDto;
import com.blog.blogService.entity.Blog;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class BlogMapper extends ConfigurableMapper {


    protected void configure(final MapperFactory factory) {
        factory.classMap(Blog.class, BlogDto.class)
                .field("author.username", "author.userName")
                .byDefault()
                .register();

    }

}
