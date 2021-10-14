package com.blog.blogService.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Table
@Entity
@Data
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

//    @Column
//    @NotNull
//    private String passHash;

//    @Column
//    @NotNull
//    private String name;
//
//    @Column
//    @NotNull
//    private String surName;

}
