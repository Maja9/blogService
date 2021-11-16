package blogService.dto;

import com.sun.istack.NotNull;
import lombok.Data;

import java.util.Date;

@Data
public class BlogDto {

    private Long blogId;

    private String blogName;

    @NotNull
    private UserDto author;

    private Date createdDate;

    private Date modifiedDate;

    private boolean isPrivate;


}
