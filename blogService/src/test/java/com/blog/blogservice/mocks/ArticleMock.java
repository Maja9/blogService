package com.blog.blogservice.mocks;

import com.blog.blogservice.entity.Article;

import java.util.Date;

public final class ArticleMock {

    public ArticleMock() {
    }

    public static Article getBasicArticleInPrivateBlog() {
        Article article = new Article();
        article.setArticleId(1L);
        article.setTitle("Title");
        article.setText("Text");
        article.setCreatedDate(new Date());
        article.setModifiedDate(new Date());
        article.setAuthor(UserMock.getBasicUser());
        article.setArticleBlog(BlogMock.getBasicPrivateBlog());

        return article;
    }

    public static Article getBasicArticleInPublicBlog() {
        Article article = new Article();
        article.setArticleId(1L);
        article.setTitle("Title");
        article.setText("Text");
        article.setCreatedDate(new Date());
        article.setModifiedDate(new Date());
        article.setAuthor(UserMock.getBasicUser());
        article.setArticleBlog(BlogMock.getBasicPublicBlog());

        return article;
    }
}
