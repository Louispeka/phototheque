package org.phototheque.service;

import org.phototheque.dto.ImageDto;
import org.phototheque.entity.Image;
import org.phototheque.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public List<ImageDto> getLastImages(int limit) {
        return imageRepository.findAll()
                .stream()
                .limit(limit)
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public ImageDto getImageDetails(Long id) {
        Image image = imageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Image not found"));
        return convertToDto(image);
    }

    public void saveImage(ImageDto imageDto) {
        Image image = convertToEntity(imageDto);
        imageRepository.save(image);
    }

    private ImageDto convertToDto(Image image) {
        return new ImageDto(image.getName(), image.getCategory(), image.getDescription());
    }

    private Image convertToEntity(ImageDto imageDto) {
        Image image = new Image();
        image.setName(imageDto.getName());
        image.setCategory(imageDto.getCategory());
        image.setDescription(imageDto.getDescription());
        return image;
    }
}
