package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Inquiry;
import com.example.demo.entity.Staff;
import com.example.demo.repository.InquiryRepository;
import com.example.demo.repository.StaffRepository;
import com.example.demo.service.intrf.InquiryRepo;

@Service
public class InquiryImp implements InquiryRepo {

    @Autowired
    private InquiryRepository repository;

    @Autowired
    private StaffRepository staffRepository;

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
        return repository.findByStatusAndStaffIsNull(Inquiry.InquiryStatus.New);
    }

    @Override
    public List<Inquiry> getInquiryByStaff(Integer staffId) {
        return repository.findByStaffStaffId(staffId);
    }

    @Override
    public Inquiry assignInquiry(Integer inquiryId, Integer staffId) {

        Inquiry inquiry = repository.findById(inquiryId)
                .orElseThrow(() -> new RuntimeException("Inquiry not found"));

        Staff staff = staffRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        inquiry.setStaff(staff);
        inquiry.setStatus(Inquiry.InquiryStatus.In_Followup);

        return repository.save(inquiry);
    }
}