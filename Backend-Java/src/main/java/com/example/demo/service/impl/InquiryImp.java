package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.StaffRepository;
import com.example.demo.entity.Inquiry;
import com.example.demo.entity.Staff;
import com.example.demo.repository.InquiryRepository;
import com.example.service.intrf.InquiryRepo;

@Service
public class InquiryImp implements InquiryRepo {

    @Autowired
    InquiryRepository repository;

    @Autowired
    StaffRepository staffRepository;

    @Override
    public List<Inquiry> getInquiry() {
        return repository.findAll();
    }

    @Override
    public Optional<Inquiry> getInquiryById(int id) {
        return repository.findById(id);
    }

    @Override
    public Inquiry saveInquiry(Inquiry inquiry) {
        return repository.save(inquiry);
    }

    @Override
    public Inquiry updateInquiry(Inquiry inquiry) {
        return repository.save(inquiry);
    }

    @Override
    public void deleteInquiry(int id) {
        repository.deleteById(id);
    }

    // ================= New Methods =================

    @Override
    public List<Inquiry> getNewInquiry() {
        return repository.findByStatusAndStaffIsNull("New");
    }

    @Override
    public List<Inquiry> getInquiryByStaff(Integer staffId) {
        return repository.findByStaffStaffId(staffId);
    }

    @Override
    public Inquiry assignInquiry(Integer inquiryId, Integer staffId) {

        Inquiry inquiry = repository.findById(inquiryId).orElseThrow();

        Staff staff = staffRepository.findById(staffId).orElseThrow();

        inquiry.setStaff(staff);
        inquiry.setStatus("In-Followup");

        return repository.save(inquiry);
    }
}