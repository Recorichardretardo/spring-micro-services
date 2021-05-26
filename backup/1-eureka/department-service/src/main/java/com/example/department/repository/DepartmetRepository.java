package com.example.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.department.entity.Department;

@Repository
public interface DepartmetRepository extends JpaRepository<Department, Long> {

	 Department findByDepartmentId(Long deparmentId);

}
