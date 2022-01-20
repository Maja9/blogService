package com.blog.blogservice.mapper;

import com.blog.blogservice.dto.ArticleDto;
import com.blog.blogservice.dto.BlogDto;
import com.blog.blogservice.dto.CommentDto;
import com.blog.blogservice.dto.UserDto;
import com.blog.blogservice.entity.Article;
import com.blog.blogservice.entity.Blog;
import com.blog.blogservice.entity.Comment;
import com.blog.blogservice.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.*;

class ArticleMapperTest {

    @Test
    void shouldMapArticleToArticleDto() {

        //given
        Article article = new Article(1L, "Title", "text", new Date(), new Date(), new User(), new Blog());
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
                new UserDto(), new BlogDto(), new Set <CommentDto>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<CommentDto> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(CommentDto commentDto) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends CommentDto> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }
        });
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