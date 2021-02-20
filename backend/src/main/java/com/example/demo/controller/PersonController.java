package com.example.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Detail;
import com.example.demo.service.PersonService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todoapp")
public class PersonController {
	
	private final PersonService personService;
	@GetMapping("/details")
	public List<Detail> getAllData(){
		
		return personService.getAllDetails();
	}
	@GetMapping("/details/{id}")
	public Detail getData(@PathVariable String id) {
		return personService.getDetailsById(id);
	}
	@PostMapping("/add")
	public void postData(@RequestBody Detail details) {
		personService.createDetails(details);
	}
	@PutMapping("/update")
	public void updateData(@RequestBody Detail details) {
		personService.updateDetails(details);
		
	}
	@DeleteMapping("/remove/{id}")
	public void removeData(@PathVariable String id) {
		personService.removeDetails(id);
	}

	@GetMapping("/showname")
	public List<Detail> findName(@RequestParam("name") String name) {
		return personService.findByName(name);
	}
	@GetMapping("/page/{pageNo}/{pageSize}")
	public List<Detail>  findPaginated(@PathVariable int pageNo,@PathVariable int pageSize){
		Page<Detail> page =  personService.findPaginated(pageNo, pageSize);
		List<Detail> listOfPerson = page.getContent();
		return listOfPerson;
	}
	
	
	
	
		
	
}
