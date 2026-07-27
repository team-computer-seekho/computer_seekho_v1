package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Inquiry;


import jakarta.transaction.Transactional;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
	// All new inquiries (not assigned)
    List<Inquiry> findByStatusAndStaffIsNull(String status);

    // All inquiries assigned to a staff
    List<Inquiry> findByStaffStaffId(Integer staffId);
    

}