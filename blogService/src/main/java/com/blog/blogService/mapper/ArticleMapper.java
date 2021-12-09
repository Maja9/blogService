package com.blog.blogService.mapper;

import com.blog.blogService.dto.ArticleDto;
import com.blog.blogService.entity.Article;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper extends ConfigurableMapper {

    protected void configure(final MapperFactory factory) {
        factory.classMap(Article.class, ArticleDto.class)
                .byDefault()
                .register();
    }
}
