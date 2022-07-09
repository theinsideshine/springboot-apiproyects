package com.theinsideshine.springboot.backend.apiprojectsviewer.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.theinsideshine.springboot.backend.apiprojectsviewer.models.entity.Product;

public interface IProductDao  extends CrudRepository<Product, Long>{
	
	@Query("select p from Product p where p.name like %?1%")
	public List<Product> findByName(String term);
	
	public List<Product> findByNameContainingIgnoreCase(String term);
	
	public List<Product> findByNameStartingWithIgnoreCase(String term);


}
