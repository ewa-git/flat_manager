package pl.damianrowinski.flat_manager.model.dtos;

import lombok.Data;
import pl.damianrowinski.flat_manager.validation.constraints.CheckPassword;
import pl.damianrowinski.flat_manager.validation.constraints.UniqueLogin;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@CheckPassword
public class UserAddDTO {

    @NotBlank
    @UniqueLogin
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String passwordCheck;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    private String cityName;
    private String streetName;
    private Integer streetNumber;
    private Integer apartmentNumber;

}
