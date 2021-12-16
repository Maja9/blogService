package com.blog.blogservice.mapper;

import com.blog.blogservice.dto.ArticleDto;
import com.blog.blogservice.entity.Article;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class ArticleMapper extends ConfigurableMapper {

    @Override
    protected void configure(final MapperFactory factory) {
        factory.classMap(Article.class, ArticleDto.class)
                .byDefault()
                .register();
    }
}
