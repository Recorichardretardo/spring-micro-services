package com.example.department.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.department.entity.Department;
import com.example.department.repository.DepartmetRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmetRepository departmetRepository;

	public Department saveDepartment(Department department) {
		log.info("saveDepartment method of DepartmentService");
		return departmetRepository.save(department);
	}

	public Department findDepartmentById(Long departmentId) {
		log.info("findDeparmentById method of DepartmentService");
		return departmetRepository.findByDepartmentId(departmentId);
	}

}
