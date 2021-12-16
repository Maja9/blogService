package com.blog.blogservice.mocks;

import com.blog.blogservice.dto.BlogDto;

import java.util.Date;

public final class BlogDtoMock {

    public BlogDtoMock() {
    }

    public static BlogDto getBasicPrivateBlogDto() {
        BlogDto blogDto = new BlogDto();
        blogDto.setBlogId(1L);
        blogDto.setBlogName("ABC");
        blogDto.setAuthor(UserDtoMock.getBasicUserDto());
        blogDto.setCreatedDate(new Date());
        blogDto.setModifiedDate(new Date());
        blogDto.setPrivateBlog(true);

        return blogDto;
    }

    public static BlogDto getBasicPublicBlogDto() {
        BlogDto blogDto = new BlogDto();
        blogDto.setBlogId(1L);
        blogDto.setBlogName("ABC");
        blogDto.setAuthor(UserDtoMock.getBasicUserDto());
        blogDto.setCreatedDate(new Date());
        blogDto.setModifiedDate(new Date());
        blogDto.setPrivateBlog(false);

        return blogDto;
    }
}
