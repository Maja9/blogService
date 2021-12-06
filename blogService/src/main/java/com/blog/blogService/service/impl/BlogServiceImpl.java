package com.blog.blogService.service.impl;

import com.blog.blogService.dto.BlogDto;
import com.blog.blogService.entity.Blog;
import com.blog.blogService.mapper.BlogMapper;
import com.blog.blogService.repository.BlogRepository;
import com.blog.blogService.service.spi.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository;
    private final BlogMapper blogMapper;

    @Override
    public Long createBlog(final BlogDto blogDto) {
        Blog blogToSave = blogMapper.map(blogDto, Blog.class);
        return blogRepository.save(blogToSave)
                .getBlogId();
    }

    @Override
    public BlogDto getBlogById(final Long blogId) {
        Optional<Blog> blogOptional = blogRepository.findById(blogId);
        return blogOptional.map(blog -> blogMapper.map(blog, BlogDto.class))
                .orElse(null);
    }

    @Override
    public BlogDto updateBlog(final Long blogId, final BlogDto blogDto, final Long userId) {

        final BlogDto blogFromDb = getBlogById(blogId);
        if (blogId.equals(blogFromDb.getBlogId()) && userId.equals(blogFromDb.getAuthor().getId())) {
            createBlog(blogDto);
            return getBlogById(blogId);
        }
        return null;
    }

}
