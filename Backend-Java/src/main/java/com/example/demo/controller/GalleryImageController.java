package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.GalleryImage;
import com.example.demo.service.intrf.GalleryImageService;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "http://localhost:5173")
public class GalleryImageController {

    private final GalleryImageService galleryImageService;

    public GalleryImageController(GalleryImageService galleryImageService) {
        this.galleryImageService = galleryImageService;
    }

    // Get all active gallery images
    @GetMapping
    public ResponseEntity<List<GalleryImage>> getAllGalleryImages() {
        return ResponseEntity.ok(galleryImageService.getAllGalleryImages());
    }
}