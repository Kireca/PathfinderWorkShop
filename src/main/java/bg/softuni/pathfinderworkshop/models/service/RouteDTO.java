package bg.softuni.pathfinderworkshop.models.service;

import bg.softuni.pathfinderworkshop.models.entity.Category;
import bg.softuni.pathfinderworkshop.models.entity.Picture;
import bg.softuni.pathfinderworkshop.models.entity.User;
import bg.softuni.pathfinderworkshop.models.enums.LevelEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor

public class RouteDTO {

    private String name;
    private String description;
    private String gpxCoordinate;
    private LevelEnum level;
    private User author;
    private String videoURL;
    private Set<Picture> pictures;
    private Set<Category> categories;
}
