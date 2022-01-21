package com.blog.blogservice.mapper;

import com.blog.blogservice.dto.ArticleDto;
import com.blog.blogservice.dto.BlogDto;
import com.blog.blogservice.dto.UserDto;
import com.blog.blogservice.entity.Article;
import com.blog.blogservice.entity.Blog;
import com.blog.blogservice.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

class ArticleMapperTest {

    @Test
    void shouldMapArticleToArticleDto() {

        //given
        Article article = new Article(1L, "Title", "text", new Date(), new Date(), new User(), new Blog(), new ArrayList<>());
        ArticleMapper articleMapper = new ArticleMapper();

        //when
        final ArticleDto articleDto = articleMapper.map(article, ArticleDto.class);

        //then
        Assert.assertEquals(article.getArticleId(), articleDto.getArticleId());
        Assert.assertEquals(article.getTitle(), articleDto.getTitle());
        Assert.assertEquals(article.getText(), articleDto.getText());
        Assert.assertEquals(article.getCreatedDate(), articleDto.getCreatedDate());
        Assert.assertEquals(article.getModifiedDate(), articleDto.getModifiedDate());
    }

    @Test
    void shouldMapArticleDToToArticle() {

        //given
        ArticleDto articleDto = new ArticleDto(1L, "Title", "text", new Date(), new Date(),
                new UserDto(), new BlogDto(), new ArrayList<>());

        ArticleMapper articleMapper = new ArticleMapper();

        //when
        final Article article = articleMapper.map(articleDto, Article.class);

        //then
        Assert.assertEquals(articleDto.getArticleId(), article.getArticleId());
        Assert.assertEquals(articleDto.getTitle(), article.getTitle());
        Assert.assertEquals(articleDto.getText(), article.getText());
        Assert.assertEquals(articleDto.getCreatedDate(), article.getCreatedDate());
        Assert.assertEquals(articleDto.getModifiedDate(), article.getModifiedDate());
    }
}