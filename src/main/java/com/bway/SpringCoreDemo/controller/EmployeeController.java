package com.bway.SpringCoreDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bway.SpringCoreDemo.model.Employee;
import com.bway.SpringCoreDemo.service.DepartmentService;
import com.bway.SpringCoreDemo.service.EmployeeService;
import com.bway.SpringCoreDemo.utils.EmployeeExcelView;
import com.bway.SpringCoreDemo.utils.EmployeePdfView;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	@Autowired
	private DepartmentService deptService;
	@GetMapping("/employee")
	public String getEmployee(Model model) {
		model.addAttribute("dlist",deptService.getAllDepts());
	return "EmployeeForm";	
	}
	@PostMapping("/employee")
	public String postEmployee(@ModelAttribute Employee emp) {
		
		empService.addEmployee(emp);
		return "redirect:/employee";
	}
	@GetMapping("/employeeList")
	public String getEmployees(Model model) {
		model.addAttribute("elist",empService.getAllEmployees());
		return "EmployeeList";
	}
	@GetMapping("/emp/delete") // deleting the data
	public String delete(@RequestParam long id ) {
		empService.deleteEmployee(id);
		return "redirect:/employeeList";
	}
	@GetMapping("/emp/edit")
	public String edit(@RequestParam long id, Model model) {
		
		model.addAttribute("emodel",empService.getEmployeeById(id));
		return "EmployeeListEdit";
	}
	@PostMapping("/emp/update")
	public String update(@ModelAttribute Employee emp) {
		empService.updateEmployee(emp);
		return "redirect:/employeeList";
	}
	//for exporting excels and pdfs
	
		@GetMapping("/emp/excel")
		public ModelAndView excel() {
			
			ModelAndView mv  = new ModelAndView();
			mv.addObject("eList",empService.getAllEmployees());
			mv.setView(new EmployeeExcelView());
			
			return mv;
			
		}
		
		@GetMapping("emp/pdf")
		public ModelAndView pdf() {
			ModelAndView mv  = new ModelAndView();
			mv.addObject("eList",empService.getAllEmployees());
			mv.setView(new EmployeePdfView());
			return mv;
		}
}
