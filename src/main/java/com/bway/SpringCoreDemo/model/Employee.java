package com.bway.SpringCoreDemo.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;



@Data
@Entity
@Table(name= "employee_table")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fname;
	private String lname;
	private String gender;
	private String email;
	private String phone;
	@DateTimeFormat(iso= ISO.DATE)
	private LocalDate dob;
	private String post;
	private int salary;
	@DateTimeFormat(iso= ISO.DATE)
	private LocalDate joinDate;
	@ManyToMany
	private List<Department> department;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="addressId")
	private Address address;
	@ElementCollection
	@CollectionTable
	private List<String> project;
	
	
	
}
