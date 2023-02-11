package bg.softuni.pathfinderworkshop.model.entity;

import bg.softuni.pathfinderworkshop.model.enums.LevelEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;

    private String password;

    private String email;

    @ManyToMany
    private Set<Role> role;

    private LevelEnum level;

}
