package com.bway.SpringCoreDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.SpringCoreDemo.model.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{
	
}
