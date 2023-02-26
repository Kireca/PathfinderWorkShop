package bg.softuni.pathfinderworkshop.models.binding;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter


public class UserLoginDTO {

    @NotEmpty
    @Size(min = 5, max = 20)
    private String username;

    @Size(min = 5)
    private String password;
}
