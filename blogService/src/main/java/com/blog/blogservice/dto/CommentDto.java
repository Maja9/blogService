package com.blog.blogservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private Long commentId;

    private String text;

    private Date createdDate;

    private UserDto author;

    private ArticleDto commentArticle;
}
