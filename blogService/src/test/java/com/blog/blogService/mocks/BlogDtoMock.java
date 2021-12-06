package com.blog.blogService.mocks;

import com.blog.blogService.dto.BlogDto;

import java.util.Date;

public final class BlogDtoMock {

    public BlogDtoMock() {
    }

    public static BlogDto getBasicBlogDto() {
        BlogDto blogDto = new BlogDto();
        blogDto.setBlogId(1L);
        blogDto.setBlogName("ABC");
        blogDto.setAuthor(UserDtoMock.getBasicUserDto());
        blogDto.setCreatedDate(new Date());
        blogDto.setModifiedDate(new Date());
        blogDto.setPrivateBlog(true);

        return blogDto;
    }
}
