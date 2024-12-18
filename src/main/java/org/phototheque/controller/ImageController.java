package org.phototheque.controller;

import org.phototheque.service.ImageService;
import org.phototheque.dto.ImageDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public ResponseEntity<List<ImageDto>> getLastImages(@RequestParam(defaultValue = "10") int limit) {
        return ResponseEntity.ok(imageService.getLastImages(limit));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageDto> getImageDetails(@PathVariable Long id) {
        return ResponseEntity.ok(imageService.getImageDetails(id));
    }

    @PostMapping
    public ResponseEntity<String> uploadImage(@RequestBody ImageDto imageDto) {
        imageService.saveImage(imageDto);
        return ResponseEntity.ok("Image uploaded successfully.");
    }
}
