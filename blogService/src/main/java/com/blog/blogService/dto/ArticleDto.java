package com.blog.blogService.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private Long articleId;

    private String title;

    private  String text;

    private Date createdDate;

    private Date modifiedDate;

    @NotNull
    private UserDto author;
}
