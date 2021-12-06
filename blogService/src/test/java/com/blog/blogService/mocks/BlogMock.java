package com.blog.blogService.mocks;

import com.blog.blogService.entity.Blog;
import com.blog.blogService.entity.User;

import java.util.Date;

public final class BlogMock {

    public BlogMock() {
    }

    public static Blog getBasicBlog() {
        Blog blog = new Blog();
        blog.setBlogId(1L);
        blog.setBlogName("ABC");
        blog.setAuthor(new User());
        blog.setCreatedDate(new Date());
        blog.setModifiedDate(new Date());
        blog.setPrivateBlog(true);

        return blog;
    }
}
