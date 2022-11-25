package com.example.coffee.presentation;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coffee.model.Coffee;
import com.example.coffee.repository.CoffeeRepository;

import com.example.coffee.service.ServiceCoffeeInt;

@RestController
//@RequestMapping("/coffees")
public class RestApiDemoController {
	

//	private List<Coffee> coffees = new ArrayList<>();
	//	
	//	public RestApiDemoController() {
	//		coffees.addAll(
	//	List.of(new Coffee("Distributeur"),
	//			new Coffee("GoodOne"),
	//			new Coffee("Robusta"),
	//			new Coffee("Deca")
	//			));
	//	}
		
		
		//Constructeur
	//	public RestApiDemoController(CoffeeRepository coffeeRepository) {
	//		super();
	//		this.coffeeRepository = coffeeRepository;
	////		coffeeRepository.saveAll(List.of(new Coffee("Distributeur"),
	////				new Coffee("GoodOne"),
	////				new Coffee("Robusta"),
	////				new Coffee("Deca")));
	//	}
	
	
		
	public RestApiDemoController(ServiceCoffeeInt serviceCoffee) {
			super();
			this.serviceCoffee = serviceCoffee;
		}
//	private CoffeeRepository coffeeRepository;
	private ServiceCoffeeInt serviceCoffee;
	
////	@GetMapping("/coffees")
////	public List<Coffee> getCoffees() {
////		return coffees;
////	}
//	
//	
	@GetMapping("/coffees")
	Iterable<Coffee> getCoffees(){
	return serviceCoffee.getAllCoffees();
	}
//
//
////	@PostMapping("/coffees")
////	public Coffee postCoffee(@RequestBody Coffee coffee) {
////		//coffee.setId(UUID.randomUUID().toString());
////		coffees.add(coffee);
////		return coffee;
////	}
//	
	@PostMapping
	public Coffee postCoffee(@RequestBody Coffee coffee) {
		return serviceCoffee.postACoffee(coffee);
	}	
//	
//	
//	
////	@GetMapping("/coffees/{id}")
////	public Optional<Coffee> getCoffeeById(@PathVariable String id) {
////		for (Coffee c : coffees) {
////			if (c.getId().equals(id)) {
////					return Optional.of(c);
////			}
////		}
////		return Optional.empty();
////	}
//	
//	
	@GetMapping("/coffees/{id}")
	public Optional<Coffee> getCoffeeById(@PathVariable String id) {
		return serviceCoffee.getACoffeeById(id);
	}
	
	@GetMapping("/coffees/name/{name}")
	public List<Coffee> getByAName(@PathVariable String name){
		return (List<Coffee>) serviceCoffee.getByName(name);
	}
	
//	
////	@GetMapping("/coffees/{id}")
////	public Coffee getCoffeeById(@PathVariable String id) {
////		for (Coffee c : coffees) {
////			if (c.getId().equals(id)) {
////					return c;
////			}
////		}
////		return null;
////	}
//	
////	@PutMapping("/coffees/{id}")
////	public ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
////		int coffeeIndex = -1;
////		
////		for (Coffee c : coffees) {
////			if(c.getId().equals(id)) {
////				coffeeIndex = coffees.indexOf(c);  //je sauvgadre sa position (son index)
////				coffees.set(coffeeIndex, coffee);	// Je remplace le nouveau caffé dans la position que j'ai récupérée		
////			}
////			
////		}
////		return (coffeeIndex == -1) ? new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
////		  new ResponseEntity<>(coffee, HttpStatus.OK);
////		
////	}
//	
//	
	@PutMapping("/coffees/{id}")
	public ResponseEntity<Coffee> putACoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		return serviceCoffee.putCoffee(id, coffee);
	}
//	
////	@DeleteMapping("/coffees/{id}")
////	public List<Coffee> deleteCoffee(@PathVariable String id) {
////		
////		coffees.removeIf(c -> c.getId().equals(id));
////		
//////		for (Coffee c : coffees) {
//////			if(c.getId().equals(id)) {
//////				coffees.remove(coffees.indexOf(c));
//////				//break;
//////			}
//////		}
////		return coffees;
////
////	}
//	
//
	@DeleteMapping("/coffees/{id}")
	public void deleteACoffee(@PathVariable String id) {
	 serviceCoffee.deleteCoffee(id);	
	}	
}







