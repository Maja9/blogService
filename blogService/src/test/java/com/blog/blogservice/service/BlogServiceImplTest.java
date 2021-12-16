package com.blog.blogservice.service;

import com.blog.blogservice.dto.BlogDto;
import com.blog.blogservice.entity.Blog;
import com.blog.blogservice.entity.User;
import com.blog.blogservice.mapper.BlogMapper;
import com.blog.blogservice.mocks.BlogDtoMock;
import com.blog.blogservice.mocks.BlogMock;
import com.blog.blogservice.mocks.UserMock;
import com.blog.blogservice.repository.BlogRepository;
import com.blog.blogservice.service.impl.BlogServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class BlogServiceImplTest {


    @Mock
    private BlogMapper blogMapper;

    @Mock
    private BlogRepository blogRepository;

    private BlogServiceImpl blogService;

    @Before
    public void before() {
        openMocks(this);
        blogService = new BlogServiceImpl(blogRepository, blogMapper);
    }

    @After
    public void after() {
        reset(blogMapper, blogRepository);
    }

    @Test
    public void shouldSaveBlogInDB() {

        //given
        final BlogDto blogToSave = BlogDtoMock.getBasicPrivateBlogDto();
        final Blog blog = BlogMock.getBasicPrivateBlog();


        given(blogMapper.map(blogToSave, Blog.class)).willReturn(blog);

        given(blogRepository.save(any(Blog.class))).willReturn(blog);

        //when
        final Long saveBlogId = blogService.createBlog(blogToSave);

        //then
        verify(blogRepository, times(1)).save(any());
        assertNotNull(saveBlogId);

    }


    @Test
    public void userShouldBeAbleToEditHisOwnBlog() {
        //given
        final BlogDto blogToSave = BlogDtoMock.getBasicPrivateBlogDto();
        final Blog blog = BlogMock.getBasicPrivateBlog();
        final User user = UserMock.getBasicUser();

        given(blogMapper.map(blogToSave, Blog.class)).willReturn(blog);

        given(blogMapper.map(blog, BlogDto.class)).willReturn(blogToSave);

        given(blogRepository.save(any(Blog.class))).willReturn(blog);

        given(blogRepository.findById(anyLong())).willReturn(java.util.Optional.of(blog));

        //when
        final BlogDto updatedBlog = blogService.updateBlog(blog.getBlogId(), blogToSave, user.getId());

        //then
        verify(blogRepository, times(1)).save(any());
        assertNotNull(updatedBlog);

    }

    @Test
    public void userShouldNotBeAbleToEditSomeoneElseBlog() {
        //given
        final BlogDto blogToSave = BlogDtoMock.getBasicPrivateBlogDto();
        final Blog blog = BlogMock.getBasicPrivateBlog();

        given(blogMapper.map(blogToSave, Blog.class)).willReturn(blog);

        given(blogMapper.map(blog, BlogDto.class)).willReturn(blogToSave);

        given(blogRepository.save(any(Blog.class))).willReturn(blog);

        given(blogRepository.findById(anyLong())).willReturn(java.util.Optional.of(blog));

        //when
        final BlogDto updatedBlog = blogService.updateBlog(blog.getBlogId(), blogToSave, new Random().nextLong());

        //then
        verify(blogRepository, times(0)).save(any());
    }
}
