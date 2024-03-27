package com.bway.SpringCoreDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.SpringCoreDemo.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
