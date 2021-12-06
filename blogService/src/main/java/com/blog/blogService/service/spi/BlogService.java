package com.blog.blogService.service.spi;

import com.blog.blogService.dto.BlogDto;

public interface BlogService {

    Long createBlog(BlogDto blogDto);

    BlogDto getBlogById(Long blogId);

    BlogDto updateBlog(Long blogId, BlogDto blogDto, Long userId);
}
