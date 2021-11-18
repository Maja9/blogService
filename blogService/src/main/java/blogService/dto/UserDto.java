package blogService.dto;

import blogService.validations.LoginIsAvailable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    @NotNull(groups = UpdateUser.class)
    private Long id;

    @LoginIsAvailable
    private String userName;

    @Email
    @NotNull(groups = SendNewPassword.class)
    private String email;

    @Length(min = 6)
    @NotNull(groups = DeleteUser.class)
    private String password;

    private String name;

    private String surName;


    public interface UpdateUser {

    }

    public interface DeleteUser {

    }

    public interface SendNewPassword {

    }
}
