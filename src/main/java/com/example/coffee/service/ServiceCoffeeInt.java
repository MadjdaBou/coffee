package com.example.coffee.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.coffee.model.Coffee;

public interface ServiceCoffeeInt {

	void dataLoader();

	//	@GetMapping("/coffees")
	Iterable<Coffee> getAllCoffees();

	//	@PostMapping
	Coffee postACoffee(Coffee coffee);

	//	@GetMapping("/coffees/{id}")
	Optional<Coffee> getACoffeeById(String id);

	//	@PutMapping("/coffees/{id}")
	ResponseEntity<Coffee> putCoffee(String id, Coffee coffee);

	//	@DeleteMapping("/coffees/{id}")
	void deleteCoffee(String id);

	//	@GetMapping
	List<Coffee> getByName(String name);

}