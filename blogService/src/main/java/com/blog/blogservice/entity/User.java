package com.blog.blogservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Table(name = "userTable")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String username;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private int passHash;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String surName;

    @OneToMany(mappedBy = "author")
    private Set<Blog> blogs = new HashSet<>();

    @OneToMany(mappedBy = "author")
    private Set<Article> articles = new HashSet<>();

    public User(Long id, String username, String email, int passHash, String name, String surName, Set<Blog> blogs) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.passHash = passHash;
        this.name = name;
        this.surName = surName;
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", passHash=" + passHash +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                '}';
    }
}
