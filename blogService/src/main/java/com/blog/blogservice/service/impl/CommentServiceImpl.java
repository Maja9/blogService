package com.blog.blogservice.service.impl;

import com.blog.blogservice.dto.CommentDto;
import com.blog.blogservice.entity.Article;
import com.blog.blogservice.entity.Comment;
import com.blog.blogservice.mapper.CommentMapper;
import com.blog.blogservice.repository.ArticleRepository;
import com.blog.blogservice.repository.CommentRepository;
import com.blog.blogservice.service.spi.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final ArticleRepository articleRepository;

    @Override
    public Long createComment(final CommentDto commentDto, final Long articleId) {
        Comment commentToSave = commentMapper.map(commentDto, Comment.class);
        Optional<Article> optionalArticle = articleRepository.findById(articleId);
        optionalArticle.ifPresent(commentToSave::setCommentArticle);
        return commentRepository.save(commentToSave)
                .getCommentId();
    }

    @Override
    public CommentDto getCommentById(final Long commentId) {
        Optional<Comment> commentOptional = commentRepository.findById(commentId);
        return commentOptional.map(comment -> commentMapper.map(comment, CommentDto.class))
                .orElse(null);
    }
}
