package bg.softuni.pathfinderworkshop.models.service;

import bg.softuni.pathfinderworkshop.models.entity.Role;
import bg.softuni.pathfinderworkshop.models.enums.LevelEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@Getter
@Setter

public class UserServiceDTO {

    private Long id;
    private String username;
    private String fullName;
    private Integer age;
    private String password;
    private String email;
    private Set<Role> roles;
    private LevelEnum level;

}
