package com.blog.blogservice.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Table
@Entity
@Data
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
    @Column(updatable = false)
    @NotNull
    private Date createdDate;

    @UpdateTimestamp
    @Column
    private Date modifiedDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Blog articleBlog;

    @OneToMany(mappedBy = "commentArticle")
    private List<Comment> comments;

    public Article(Long articleId, String title, String text, Date createdDate, Date modifiedDate, User author, Blog articleBlog, List<Comment> comments) {
        this.articleId = articleId;
        this.title = title;
        this.text = text;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.author = author;
        this.articleBlog = articleBlog;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", author=" + author +
                ", articleBlog=" + articleBlog +
                ", comments=" + comments +
                '}';
    }
}