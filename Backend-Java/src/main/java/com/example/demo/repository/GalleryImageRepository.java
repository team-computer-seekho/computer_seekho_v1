package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.GalleryImage;

@Repository
public interface GalleryImageRepository extends JpaRepository<GalleryImage, Integer> {

    // Fetch only active gallery images
    List<GalleryImage> findByIsActiveTrue();

}