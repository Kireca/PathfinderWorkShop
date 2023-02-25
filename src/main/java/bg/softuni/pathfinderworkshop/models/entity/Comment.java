package bg.softuni.pathfinderworkshop.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "comments")
public class Comment  extends BaseEntity{

    @Column(nullable = false)
    private Boolean approved;

    @Column(columnDefinition = "TEXT")
    private String textContent;

    @Column(nullable = false)
    private LocalDateTime created;

    @ManyToOne
    private Route route;

    @ManyToOne
    private User author;
}
