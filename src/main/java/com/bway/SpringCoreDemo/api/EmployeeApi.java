package com.bway.SpringCoreDemo.api;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bway.SpringCoreDemo.model.Employee;
import com.bway.SpringCoreDemo.model.Product;
import com.bway.SpringCoreDemo.repo.ProductRepository;
import com.bway.SpringCoreDemo.service.EmployeeService;

@RestController
public class EmployeeApi {
	
	
	@Autowired
	private EmployeeService empservice;
	@Autowired
	private ProductRepository prepo;
		
	@GetMapping("/api/emp/list")
	public List<Employee> getAll() {
		return empservice.getAllEmployees();
	}
	
	
	@PostMapping("api/emp/add")
	public String add(@RequestBody Employee emp) {   //requestBody for converting object to json
		return "add success";
	}
	@GetMapping("/api/emp/{id}")
	public Employee getOne(@PathVariable Long  id) {
		return empservice.getEmployeeById(id);
	}
	
	
	@PutMapping("/api/emp/update")
	public String update(@RequestBody Employee emp) {
		return "success";
	}
	
	@DeleteMapping("/api/emp/delete/{id}")
	public String delete(Long id) {
		empservice.deleteEmployee(id);
		return "deleted successfully";
	}
	
	
	@GetMapping("/api/emp/j2o")
	public String jsonToObjectMapping() {
		
		RestTemplate rt = new RestTemplate();
	Employee emp = 	rt.getForObject("https://localhost:9000/api/emp/1", Employee.class);
		return "FirstName="+emp.getFname();
	}
	@GetMapping("/api/emp/ja2oa")
	public String jsonToObjArray() {
		RestTemplate rt = new RestTemplate();
		Employee[] emps =  rt.getForObject("https://localhost:9000/api/emp/list", Employee[].class);
		return "Email="+emps[0].getEmail();
	}
	
	@GetMapping("/api/pload")
	public String loadProduct() {
		RestTemplate rt = new RestTemplate();
		Product[] plist =  rt.getForObject("https://fakestoreapi.com/products", Product[].class);
		prepo.saveAll(List.of(plist));
		return "success";
	}
}
