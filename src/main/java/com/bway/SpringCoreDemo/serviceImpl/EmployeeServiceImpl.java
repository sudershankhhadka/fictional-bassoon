package com.bway.SpringCoreDemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.SpringCoreDemo.model.Employee;
import com.bway.SpringCoreDemo.repo.employeeRepository;
import com.bway.SpringCoreDemo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	  private employeeRepository empRepo;
		@Override
		public void addEmployee(Employee emp) {
			empRepo.save(emp);
			
		}

		@Override
		public void deleteEmployee(Long id) {
			empRepo.deleteById(id);
			
		}

		

		@Override
		public Employee getEmployeeById(Long id) {
			return empRepo.findById(id).get();
			
		}

		@Override
		public List<Employee> getAllEmployees() {
			return empRepo.findAll();
		}

		@Override
		public void updateEmployee(Employee emp) {
			empRepo.save(emp);
			
		}
}
