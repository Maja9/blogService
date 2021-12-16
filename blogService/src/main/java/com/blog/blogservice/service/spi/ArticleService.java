package com.blog.blogservice.service.spi;

import com.blog.blogservice.dto.ArticleDto;

public interface ArticleService {

    Long createArticle(ArticleDto articleDto, Long blogId);

    ArticleDto getArticleById(Long articleId);

    ArticleDto updateArticle(Long articleId, ArticleDto articleDto, Long userId, Long blogId);
}
