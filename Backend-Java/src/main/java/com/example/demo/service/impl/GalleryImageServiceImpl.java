package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.GalleryImage;
import com.example.demo.repository.GalleryImageRepository;
import com.example.demo.service.intrf.GalleryImageService;

@Service
public class GalleryImageServiceImpl implements GalleryImageService {

    private final GalleryImageRepository galleryImageRepository;

    public GalleryImageServiceImpl(GalleryImageRepository galleryImageRepository) {
        this.galleryImageRepository = galleryImageRepository;
    }

    @Override
    public List<GalleryImage> getAllGalleryImages() {
        return galleryImageRepository.findByIsActiveTrue();
    }

}