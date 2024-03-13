package com.bway.SpringCoreDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bway.SpringCoreDemo.model.Department;
import com.bway.SpringCoreDemo.service.DepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService deptservice;
	
	@GetMapping("/department")
	public String getDepartment() {
		return "DepartmentForm";
	}
	
	
	@PostMapping("/department")
	public String postDepartment(@ModelAttribute Department dept) {
		deptservice.addDept(dept);
		return "DepartmentForm";
	}
	@GetMapping("/departmentList")
	public String getDepartments(Model model) {
		model.addAttribute("dlist",deptservice.getAllDepts());
		return "DepartmentListForm";
	}
	@GetMapping("/dept/delete")
	public String delete(@RequestParam int id ) {
		deptservice.deleteDept(id);
		return "redirect:/departmentList";
	}
	
	@GetMapping("/dept/edit")
	public String edit(@RequestParam int id, Model model) {
		
		model.addAttribute("dmodel",deptservice.getDeptById(id));
		return "DepartmentEditForm";
	}
	@PostMapping("/dept/update")
	public String update(@ModelAttribute Department dept) {
		deptservice.updateDept(dept);
		return "redirect:/departmentList";
	}
	
}
