package com.bway.SpringCoreDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.SpringCoreDemo.model.Employee;

public interface employeeRepository extends JpaRepository<Employee, Long>{
	
}
