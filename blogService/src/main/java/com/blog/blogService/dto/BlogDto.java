package com.blog.blogService.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import javax.validation.constraints.NotNull;


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
