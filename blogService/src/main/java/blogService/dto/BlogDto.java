package blogService.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {

    private Long blogId;

    private String blogName;

    @NotNull
    private UserDto author;

    private Date createdDate;

    private Date modifiedDate;

    private boolean isPrivate;


}
