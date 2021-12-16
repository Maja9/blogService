package com.blog.blogservice.service.spi;

import com.blog.blogservice.dto.BlogDto;

public interface BlogService {

    Long createBlog(BlogDto blogDto);

    BlogDto getBlogById(Long blogId);

    BlogDto updateBlog(Long blogId, BlogDto blogDto, Long userId);
}
