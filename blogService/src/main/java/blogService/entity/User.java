package blogService.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    @Column
    @NotNull
    private int passHash;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String surName;

    @OneToMany(mappedBy = "author" )
    private Set<Blog> blogs = new HashSet<>();

}
