package com.blog.blogservice.service;

import com.blog.blogservice.dto.ArticleDto;
import com.blog.blogservice.dto.BlogDto;
import com.blog.blogservice.entity.Article;
import com.blog.blogservice.entity.Blog;
import com.blog.blogservice.mapper.ArticleMapper;
import com.blog.blogservice.mapper.CommentMapper;
import com.blog.blogservice.mocks.*;
import com.blog.blogservice.repository.ArticleRepository;
import com.blog.blogservice.repository.BlogRepository;
import com.blog.blogservice.service.impl.ArticleServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class ArticleServiceImplTest {


    @Mock
    private ArticleMapper articleMapper;

    @Mock
    private CommentMapper commentMapper;

    @Mock
    private ArticleRepository articleRepository;

    @Mock
    private BlogRepository blogRepository;

    private ArticleServiceImpl articleService;

    @Before
    public void before() {
        openMocks(this);
        articleService = new ArticleServiceImpl(articleRepository, articleMapper, blogRepository, commentMapper);
    }

    @After
    public void after() {
        reset(articleMapper, articleRepository, blogRepository);
    }

    @Test
    public void shouldSaveArticleInDB() {

        //given
        final ArticleDto articleToSave = ArticleDtoMock.getBasicArticleDtoInPrivateBlog();
        final Article article = ArticleMock.getBasicArticleInPrivateBlog();
        final BlogDto blogDto = BlogDtoMock.getBasicPrivateBlogDto();

        given(articleMapper.map(articleToSave, Article.class)).willReturn(article);
        given(articleRepository.save(any(Article.class))).willReturn(article);

        //when
        final Long saveArticleId = articleService.createArticle(articleToSave, blogDto.getBlogId());

        //then
        verify(articleRepository, times(1)).save(any());
        assertNotNull(saveArticleId);

    }


    @Test
    public void userShouldBeAbleToEditHisOwnArticle() {
        //given
        final ArticleDto articleToSave = ArticleDtoMock.getBasicArticleDtoInPrivateBlog();
        final Article article = ArticleMock.getBasicArticleInPrivateBlog();
        final Blog blog = BlogMock.getBasicPrivateBlog();

        given(articleMapper.map(articleToSave, Article.class)).willReturn(article);
        given(articleMapper.map(article, ArticleDto.class)).willReturn(articleToSave);
        given(articleRepository.save(any(Article.class))).willReturn(article);
        given(articleRepository.findById(anyLong())).willReturn(java.util.Optional.of(article));

        //then
        final ArticleDto updatedArticle = articleService.updateArticle(article.getArticleId(), articleToSave, blog.getAuthor().getId(), blog.getBlogId());

        //then
        verify(articleRepository, times(1)).save(any());
        assertNotNull(updatedArticle);

    }

    @Test
    public void userShouldNotBeAbleToEditSomeoneElseArticle() {
        //given
        final ArticleDto articleToSave = ArticleDtoMock.getBasicArticleDtoInPrivateBlog();
        final Article article = ArticleMock.getBasicArticleInPrivateBlog();
        final Blog blog = BlogMock.getBasicPrivateBlog();

        given(articleMapper.map(articleToSave, Article.class)).willReturn(article);
        given(articleMapper.map(article, ArticleDto.class)).willReturn(articleToSave);
        given(articleRepository.save(any(Article.class))).willReturn(article);
        given(articleRepository.findById(anyLong())).willReturn(java.util.Optional.of(article));

        //then
        final ArticleDto updatedArticle = articleService.updateArticle(article.getArticleId(), articleToSave, new Random().nextLong(), blog.getBlogId());

        //then
        verify(articleRepository, times(0)).save(any());

    }

    @Test
    public void userShouldBeAbleToPublicOnSomeoneElsePublicBlog() {
        //given
        final ArticleDto articleToSave = ArticleDtoMock.getBasicArticleDtoInPublicBlog();
        articleToSave.setAuthor(UserDtoMock.getAnotherUserDto());

        final Article article = ArticleMock.getBasicArticleInPublicBlog();
        final BlogDto blogDto = BlogDtoMock.getBasicPublicBlogDto();

        given(articleMapper.map(articleToSave, Article.class)).willReturn(article);
        given(articleRepository.save(any(Article.class))).willReturn(article);

        //then
        final Long saveArticleId = articleService.createArticle(articleToSave, blogDto.getBlogId());

        //then
        verify(articleRepository, times(1)).save(any());
        assertNotNull(saveArticleId);

    }
}