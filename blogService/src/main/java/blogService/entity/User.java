package blogService.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
