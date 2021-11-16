package blogService.entity;

import com.sun.istack.NotNull;
import lombok.Data;
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

    @Column
    @NotNull
    Date createdDate;

    @Column
    Date modifiedDate;

    @Column
    boolean isPrivat;

}
