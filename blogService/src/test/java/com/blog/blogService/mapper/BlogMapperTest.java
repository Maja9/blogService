package com.blog.blogService.mapper;

import blogService.dto.BlogDto;
import blogService.dto.UserDto;
import blogService.entity.Blog;
import blogService.entity.User;
import blogService.mapper.BlogMapper;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class BlogMapperTest {

    @Test
    public void shouldMapBlogToBlogDto() {

        //given
        Blog blog = new Blog(1L, "NazwaBloga", new User(), new Date(), new Date(), true);
        BlogMapper blogMapper = new BlogMapper();

        //when
        final BlogDto blogDto = blogMapper.map(blog, BlogDto.class);

        //then
        Assert.assertEquals(blog.getBlogId(), blogDto.getBlogId());
        Assert.assertEquals(blog.getBlogName(), blogDto.getBlogName());
        Assert.assertEquals(blog.getCreatedDate(), blogDto.getCreatedDate());
        Assert.assertEquals(blog.getModifiedDate(), blogDto.getModifiedDate());
        Assert.assertEquals(blog.isPrivateBlog(), blogDto.isPrivateBlog());
        Assert.assertEquals(blog.getCreatedDate(), blogDto.getCreatedDate());
        Assert.assertEquals(blog.getModifiedDate(), blogDto.getModifiedDate());

    }

    @Test
    public void shouldMapBlogDtoToBlog() {

        //given
        BlogDto blogDto = new BlogDto(2L, "NazwaBloga2", new UserDto(), new Date(), new Date(), true);
        BlogMapper blogMapper = new BlogMapper();

        //when
        final Blog blog = blogMapper.map(blogDto, Blog.class);

        //then
        Assert.assertEquals(blogDto.getBlogId(), blog.getBlogId());
        Assert.assertEquals(blogDto.getBlogName(), blog.getBlogName());
        Assert.assertEquals(blogDto.getCreatedDate(), blog.getCreatedDate());
        Assert.assertEquals(blogDto.getModifiedDate(), blog.getModifiedDate());
        Assert.assertEquals(blogDto.isPrivateBlog(), blog.isPrivateBlog());
        Assert.assertEquals(blogDto.getCreatedDate(), blog.getCreatedDate());
        Assert.assertEquals(blogDto.getModifiedDate(), blog.getModifiedDate());
    }
}
