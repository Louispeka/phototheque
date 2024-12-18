package org.phototheque.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ImageDto {


    private String name;
    private String category;
    private String description;


    public ImageDto(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

}
