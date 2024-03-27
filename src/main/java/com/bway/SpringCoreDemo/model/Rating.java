package com.bway.SpringCoreDemo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Rating {
	
		@Id
		@GeneratedValue
		private int id;
		private Double rate;
		private int count;
}
