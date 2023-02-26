package bg.softuni.pathfinderworkshop.models.view;

import bg.softuni.pathfinderworkshop.models.enums.LevelEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

public class UserViewModel {

    private Long id;
    private String fullName;
    private String username;
    private int age;
    private LevelEnum level;

}
