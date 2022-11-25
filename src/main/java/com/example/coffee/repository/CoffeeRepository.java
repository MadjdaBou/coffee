package com.example.coffee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.example.coffee.model.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, String>, JpaRepository<Coffee, String>{
	
	List<Coffee> findByName(String name);
}
