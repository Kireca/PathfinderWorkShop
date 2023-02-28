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
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "LONGTEXT", name = "gpx_coordinates")
    private String gpxCoordinate;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @ManyToOne
    private User author;

    @Column(name = "video_url")
    private String videoURL;

    @OneToMany(mappedBy = "route",fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Category> categories;

}
