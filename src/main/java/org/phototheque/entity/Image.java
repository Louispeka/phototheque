package org.phototheque.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Getters et Setters
    @Setter
    @Getter
    private String name;
    @Setter
    @Getter
    private String category;
    @Setter
    @Getter
    private String description;

}
