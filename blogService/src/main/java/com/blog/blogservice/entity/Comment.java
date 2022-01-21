package com.blog.blogservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column
    @NotNull
    private String text;

    @CreationTimestamp
    @Column(updatable = false)
    //@NotNull
    private Date createdDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Article commentArticle;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", text='" + text + '\'' +
                ", createdDate=" + createdDate +
                ", author=" + author +
                ", commentArticle=" + commentArticle +
                '}';
    }
}
