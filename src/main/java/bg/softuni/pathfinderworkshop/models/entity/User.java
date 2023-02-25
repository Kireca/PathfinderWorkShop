package bg.softuni.pathfinderworkshop.models.entity;

import bg.softuni.pathfinderworkshop.models.enums.LevelEnum;
import jakarta.persistence.*;
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

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, name = "full_name")
    private String fullName;

    @Column
    private Integer age;

    @Column(nullable = false)
    private String password;

    @Column(unique = true)
    private String email;

    @ManyToMany
    private Set<Role> roles;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

}
