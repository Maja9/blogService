package com.blog.blogservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    @NotNull(groups = UpdateArticle.class)
    private Long articleId;

    private String title;

    private String text;

    private Date createdDate;

    private Date modifiedDate;

    @NotNull
    private UserDto author;

    private BlogDto articleBlog;

    private List<CommentDto> commentsDto;

    public interface UpdateArticle {

    }
}
