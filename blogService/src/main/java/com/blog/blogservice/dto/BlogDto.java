package com.blog.blogservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDto {

    @NotNull(groups = UpdateBlog.class)
    private Long blogId;

    private String blogName;

    @NotNull
    private UserDto author;

    private Date createdDate;

    private Date modifiedDate;

    private boolean privateBlog;


    public interface UpdateBlog {

    }
}
