package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Staff;
import com.example.demo.service.intrf.StaffRepo;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffRepo staffRepo;

    // Get All Staff
    @GetMapping
    public List<Staff> getAllStaff() {
        return staffRepo.getAllStaff();
    }

    // Get Staff By Id
    @GetMapping("/{id}")
    public Optional<Staff> getStaffById(@PathVariable Integer id) {
        return staffRepo.getStaffById(id);
    }

    // Add Staff
    @PostMapping
    public Staff saveStaff(@RequestBody Staff staff) {
        return staffRepo.saveStaff(staff);
    }

    // Update Staff
    @PutMapping("/{id}")
    public Staff updateStaff(@PathVariable Integer id, @RequestBody Staff staff) {

        staff.setStaffId(id);

        return staffRepo.updateStaff(staff);
    }

    // Delete Staff
    @DeleteMapping("/{id}")
    public String deleteStaff(@PathVariable Integer id) {

        staffRepo.deleteStaff(id);

        return "Staff Deleted Successfully";
    }
}