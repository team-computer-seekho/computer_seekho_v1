package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Inquiry;
import com.example.demo.service.intrf.InquiryRepo;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/inquiry")
public class InquiryController {

    @Autowired
    InquiryRepo inquiryRepo;

    // Get All Inquiries
    @GetMapping
    public List<Inquiry> getAllInquiry() {
        return inquiryRepo.getInquiry();
    }

    // Get Inquiry By Id
    @GetMapping("/{id}")
    public Optional<Inquiry> getInquiryById(@PathVariable int id) {
        return inquiryRepo.getInquiryById(id);
    }

    // Insert Inquiry
    @PostMapping
    public Inquiry saveInquiry(@RequestBody Inquiry inquiry) {
        return inquiryRepo.saveInquiry(inquiry);
    }

    // Update Inquiry
    @PutMapping("/{id}")
    public Inquiry updateInquiry(@PathVariable int id, @RequestBody Inquiry inquiry) {

        inquiry.setInquiryId(id);   // Change according to your entity field name

        return inquiryRepo.updateInquiry(inquiry);
    }

    // Delete Inquiry
    @DeleteMapping("/{id}")
    public String deleteInquiry(@PathVariable int id) {

        inquiryRepo.deleteInquiry(id);

        return "Inquiry Deleted Successfully";
    }
 // All New Inquiries
    @GetMapping("/new")
    public List<Inquiry> getNewInquiry() {
        return inquiryRepo.getNewInquiry();
    }

    // My Follow-ups
    @GetMapping("/staff/{staffId}")
    public List<Inquiry> getInquiryByStaff(@PathVariable Integer staffId) {
        return inquiryRepo.getInquiryByStaff(staffId);
    }

    // Take Inquiry
    @PutMapping("/{inquiryId}/take/{staffId}")
    public Inquiry assignInquiry(@PathVariable Integer inquiryId,
                                 @PathVariable Integer staffId) {

        return inquiryRepo.assignInquiry(inquiryId, staffId);
    }

}