package com.bway.SpringCoreDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="department_table")
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dpt_name;
	private String dpt_head;
	private String dpt_phone;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDpt_name() {
		return dpt_name;
	}
	public void setDpt_name(String dpt_name) {
		this.dpt_name = dpt_name;
	}
	public String getDpt_head() {
		return dpt_head;
	}
	public void setDpt_head(String dpt_head) {
		this.dpt_head = dpt_head;
	}
	public String getDpt_phone() {
		return dpt_phone;
	}
	public void setDpt_phone(String dpt_phone) {
		this.dpt_phone = dpt_phone;
	}
	
	
}
