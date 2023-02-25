package bg.softuni.pathfinderworkshop.models.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
public class Message extends BaseEntity {

    @Column(nullable = false)
    private LocalDateTime dateTime;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String textContent;

    @ManyToOne
    private User author;

    @ManyToOne
    private User recipient;

}
