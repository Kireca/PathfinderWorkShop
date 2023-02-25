package bg.softuni.pathfinderworkshop.models.entity;

import bg.softuni.pathfinderworkshop.models.enums.CategoryNameEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor


@Entity
@Table(name = "categories")
public class Category extends BaseEntity {


    @Enumerated(EnumType.STRING)
    private CategoryNameEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;


}
