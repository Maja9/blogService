package com.blog.blogservice.service.impl;

import com.blog.blogservice.dto.ArticleDto;
import com.blog.blogservice.dto.CommentDto;
import com.blog.blogservice.entity.Article;
import com.blog.blogservice.entity.Blog;
import com.blog.blogservice.mapper.ArticleMapper;
import com.blog.blogservice.mapper.CommentMapper;
import com.blog.blogservice.repository.ArticleRepository;
import com.blog.blogservice.repository.BlogRepository;
import com.blog.blogservice.service.spi.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    private final BlogRepository blogRepository;
    private final CommentMapper commentMapper;

    @Override
    public Long createArticle(final ArticleDto articleDto, final Long blogId) {
        Article articleToSave = articleMapper.map(articleDto, Article.class);
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
        if (optionalBlog.isPresent()) {
            if (!isUserAbleToCreatePost(articleDto, blogId, optionalBlog.get())) {
                return null;
            }
            articleToSave.setArticleBlog(optionalBlog.get());
        }
        return articleRepository.save(articleToSave)
                .getArticleId();
    }

    private boolean isUserAbleToCreatePost(final ArticleDto articleDto, final Long blogId, final Blog blog) {
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);

        return optionalBlog.filter(blogFromDB -> blogFromDB.getAuthor().getId().equals(articleDto.getAuthor().getId()) || !blog.isPrivateBlog()).isPresent();
    }

    @Override
    public ArticleDto getArticleById(final Long articleId) {
        Optional<Article> articleOptional = articleRepository.findById(articleId);
        if (articleOptional.isPresent()) {
            List<CommentDto> commentDtos = articleOptional.get().getComments().stream()
                    .map(comment -> commentMapper.map(comment, CommentDto.class))
                    .collect(Collectors.toList());
            ArticleDto articleDto = articleMapper.map(articleOptional.get(), ArticleDto.class);
            articleDto.setCommentsDto(commentDtos);
            return articleDto;
        }
        return null;

    }

    @Override
    public ArticleDto updateArticle(final Long articleId, final ArticleDto articleDto, final Long userId, final Long blogId) {
        final ArticleDto articleFromDB = getArticleById(articleId);
        if (articleId.equals(articleFromDB.getArticleId()) && userId.equals(articleFromDB.getAuthor().getId())) {
            createArticle(articleDto, blogId);
            return getArticleById(articleId);
        }
        return null;
    }
}
