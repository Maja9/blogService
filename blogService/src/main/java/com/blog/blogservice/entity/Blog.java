package com.blog.blogservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blogId;

    @Column
    @NotNull
    private String blogName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @OneToMany(mappedBy = "articleBlog")
    private Set<Article> articles = new HashSet<>();

    @CreationTimestamp
    @Column(updatable = false)
    @NotNull
    private Date createdDate;

    @UpdateTimestamp
    @Column
    private Date modifiedDate;

    @Column
    private boolean privateBlog;

    public Blog(Long blogId, String blogName, User author, Date createdDate, Date modifiedDate, boolean privateBlog) {
        this.blogId = blogId;
        this.blogName = blogName;
        this.author = author;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.privateBlog = privateBlog;
    }
}
