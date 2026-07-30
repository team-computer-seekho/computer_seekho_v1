package com.example.demo.service.intrf;

import java.util.List;

import com.example.demo.entity.GalleryImage;

public interface GalleryImageService {

    // Get all active gallery images
    List<GalleryImage> getAllGalleryImages();

}