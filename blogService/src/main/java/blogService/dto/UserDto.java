package blogService.dto;

import blogService.controler.LoginIsAvailable;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class UserDto {
    @NotNull(groups = UpdateUser.class)
    private Long id;
    @LoginIsAvailable
    private String userName;
    @Email
    private String email;
    @Length(min = 6)
    @NotNull(groups = DeleteUser.class)
    private String password;
    private String name;
    private String surName;

    public interface UpdateUser {

    }

    public interface DeleteUser{

    }
}
