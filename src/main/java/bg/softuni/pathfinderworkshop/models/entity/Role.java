package bg.softuni.pathfinderworkshop.models.entity;


import bg.softuni.pathfinderworkshop.models.enums.RoleNameEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private RoleNameEnum role;




}
