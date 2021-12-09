package com.blog.blogService.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long articleId;

    @Column
    @NotNull
    private String title;

    @Column
    @NotNull
    private String text;

    @CreationTimestamp
    @Column (updatable = false)
    @NotNull
    private Date createdDate;

    @CreationTimestamp
    @Column
    private Date modifiedDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Blog articleBlog;
}