package com.example.demo.service.intrf;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Staff;


public interface StaffRepo {

    List<Staff> getAllStaff();

    Optional<Staff> getStaffById(Integer id);

    Staff saveStaff(Staff staff);

    Staff updateStaff(Staff staff);

    void deleteStaff(Integer id);
}