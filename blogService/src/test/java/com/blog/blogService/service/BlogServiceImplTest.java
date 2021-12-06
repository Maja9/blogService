package com.blog.blogService.service;

import com.blog.blogService.dto.BlogDto;
import com.blog.blogService.entity.Blog;
import com.blog.blogService.entity.User;
import com.blog.blogService.mapper.BlogMapper;
import com.blog.blogService.repository.BlogRepository;
import com.blog.blogService.service.impl.BlogServiceImpl;
import com.blog.blogService.mocks.BlogDtoMock;
import com.blog.blogService.mocks.BlogMock;
import com.blog.blogService.mocks.UserMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Random;

import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.openMocks;
import static org.mockito.Mockito.*;

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
        final BlogDto blogToSave = BlogDtoMock.getBasicBlogDto();
        final Blog blog = BlogMock.getBasicBlog();


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
        final BlogDto blogToSave = BlogDtoMock.getBasicBlogDto();
        final Blog blog = BlogMock.getBasicBlog();
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
        final BlogDto blogToSave = BlogDtoMock.getBasicBlogDto();
        final Blog blog = BlogMock.getBasicBlog();

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
