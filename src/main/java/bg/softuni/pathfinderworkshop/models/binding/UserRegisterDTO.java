package bg.softuni.pathfinderworkshop.models.binding;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

@NoArgsConstructor
@Getter
@Setter

public class UserRegisterDTO {

    @NotEmpty
    @Size(min = 5 , max = 20)
    private String username;

    @NotEmpty
    @Size(min = 5 , max = 20)
    private String fullName;



    @Email
    private String email;

    @Positive
    @Min(10)
    private int age;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

}
