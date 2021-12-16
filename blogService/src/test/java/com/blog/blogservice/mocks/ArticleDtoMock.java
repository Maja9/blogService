package com.blog.blogservice.mocks;

import com.blog.blogservice.dto.ArticleDto;

import java.util.Date;

public final class ArticleDtoMock {

    private ArticleDtoMock() {
    }

    public static ArticleDto getBasicArticleDtoInPrivateBlog() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setArticleId(1L);
        articleDto.setTitle("Title");
        articleDto.setText("Text");
        articleDto.setCreatedDate(new Date());
        articleDto.setModifiedDate(new Date());
        articleDto.setAuthor(UserDtoMock.getBasicUserDto());
        articleDto.setArticleBlog(BlogDtoMock.getBasicPrivateBlogDto());

        return articleDto;
    }

    public static ArticleDto getBasicArticleDtoInPublicBlog() {
        ArticleDto articleDto = new ArticleDto();
        articleDto.setArticleId(1L);
        articleDto.setTitle("Title");
        articleDto.setText("Text");
        articleDto.setCreatedDate(new Date());
        articleDto.setModifiedDate(new Date());
        articleDto.setAuthor(UserDtoMock.getBasicUserDto());
        articleDto.setArticleBlog(BlogDtoMock.getBasicPublicBlogDto());

        return articleDto;
    }
}
