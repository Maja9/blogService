package com.blog.blogservice.mocks;

import com.blog.blogservice.entity.Blog;

import java.util.Date;

public final class BlogMock {

    public BlogMock() {
    }

    public static Blog getBasicPrivateBlog() {
        Blog blog = new Blog();
        blog.setBlogId(1L);
        blog.setBlogName("ABC");
        blog.setAuthor(UserMock.getBasicUser());
        blog.setCreatedDate(new Date());
        blog.setModifiedDate(new Date());
        blog.setPrivateBlog(true);

        return blog;
    }

    public static Blog getBasicPublicBlog() {
        Blog blog = new Blog();
        blog.setBlogId(1L);
        blog.setBlogName("ABC");
        blog.setAuthor(UserMock.getBasicUser());
        blog.setCreatedDate(new Date());
        blog.setModifiedDate(new Date());
        blog.setPrivateBlog(false);

        return blog;
    }
}
