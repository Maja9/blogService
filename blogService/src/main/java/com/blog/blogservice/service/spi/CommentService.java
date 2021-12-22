package com.blog.blogservice.service.spi;

import com.blog.blogservice.dto.CommentDto;

public interface CommentService {

    Long createComment(CommentDto commentDto, Long articleId);

    CommentDto getCommentById(Long commentId);
}
