package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.StaffRepository;
import com.example.demo.entity.Staff;
import com.example.service.intrf.StaffRepo;

@Service
public class StaffImp implements StaffRepo{

	 @Autowired
	    private StaffRepository repository;

	    @Override
	    public List<Staff> getAllStaff() {
	        return repository.findAll();
	    }

	    @Override
	    public Optional<Staff> getStaffById(Integer id) {
	        return repository.findById(id);
	    }

	    @Override
	    public Staff saveStaff(Staff staff) {
	        return repository.save(staff);
	    }

	    @Override
	    public Staff updateStaff(Staff staff) {
	        return repository.save(staff);
	    }

	    @Override
	    public void deleteStaff(Integer id) {
	        repository.deleteById(id);
	    }

}
