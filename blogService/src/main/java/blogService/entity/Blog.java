package blogService.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Table
@Entity
@Data
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

    @CreationTimestamp
    @Column
    @NotNull
    Date createdDate;

    @UpdateTimestamp
    @Column
    Date modifiedDate;

    @Column
    boolean isPrivat;

}
