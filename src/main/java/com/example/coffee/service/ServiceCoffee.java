package com.example.coffee.service;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.coffee.model.Coffee;

import com.example.coffee.repository.CoffeeRepository;

@Service
public class ServiceCoffee implements ServiceCoffeeInt {

	private CoffeeRepository coffeeRepository; //c'est le DAO
	
	public ServiceCoffee(CoffeeRepository coffeeRepository) {
		super();
		this.coffeeRepository = coffeeRepository;
	}
	
	@PostConstruct
	@Override
	public void dataLoader() {
		coffeeRepository.saveAll(List.of(new Coffee("Distributeur"),
				new Coffee("GoodOne"),
				new Coffee("Robusta"),
				new Coffee("Deca")));
	}
	
//	@GetMapping("/coffees")
	@Override
	public Iterable<Coffee> getAllCoffees(){
	return coffeeRepository.findAll();
	}
	
//	@PostMapping
	@Override
	public Coffee postACoffee(@RequestBody Coffee coffee) {
		return coffeeRepository.save(coffee);
	}	
	
//	@GetMapping("/coffees/{id}")
	@Override
	public Optional<Coffee> getACoffeeById(@PathVariable String id) {
		return coffeeRepository.findById(id);
	}
	
	@Override
//	@PutMapping("/coffees/{id}")
	public ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		return (coffeeRepository.existsById(id)) ? new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.CREATED) :
			  new ResponseEntity<>(coffeeRepository.save(coffee), HttpStatus.OK);
	}
	
	@Override
//	@DeleteMapping("/coffees/{id}")
	public void deleteCoffee(@PathVariable String id) {
	 coffeeRepository.deleteById(id);	
	}	
	
//	@GetMapping
	@Override
	public List<Coffee> getByName(String name) {
	return coffeeRepository.findByName(name);
}
}
