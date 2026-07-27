package com.example.demo.service.intrf;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Inquiry;

public interface InquiryRepo {

    List<Inquiry> getInquiry();

    Optional<Inquiry> getInquiryById(int id);

    Inquiry saveInquiry(Inquiry inquiry);

    Inquiry updateInquiry(Inquiry inquiry);

    void deleteInquiry(int id);
    
    List<Inquiry> getNewInquiry();

    List<Inquiry> getInquiryByStaff(Integer staffId);

    Inquiry assignInquiry(Integer inquiryId, Integer staffId);

}