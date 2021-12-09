package com.blog.blogService.service.impl;

import com.blog.blogService.dto.ArticleDto;
import com.blog.blogService.entity.Article;
import com.blog.blogService.entity.Blog;
import com.blog.blogService.mapper.ArticleMapper;
import com.blog.blogService.repository.ArticleRepository;
import com.blog.blogService.repository.BlogRepository;
import com.blog.blogService.service.spi.ArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    private final BlogRepository blogRepository;

    @Override
    public Long createArticle(final ArticleDto articleDto, final Long blogId) {
        Article articleToSave = articleMapper.map(articleDto, Article.class);
        Optional<Blog> optionalBlog = blogRepository.findById(blogId);
       optionalBlog.ifPresent(blog -> {
           if (!blog.isPrivateBlog()) {
               articleToSave.setArticleBlog(blog);
           }
       });
        return articleRepository.save(articleToSave)
                .getArticleId();
    }
}
