package com.blog.blogService.service.spi;

import com.blog.blogService.dto.ArticleDto;

public interface ArticleService {

    Long createArticle(ArticleDto articleDto, Long blogId);
}
