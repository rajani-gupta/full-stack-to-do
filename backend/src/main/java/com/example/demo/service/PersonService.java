package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Detail;
import com.example.demo.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {
	
	private final PersonRepository personRepository; 
	
	public List<Detail> getAllDetails(){
		return personRepository.findAll();
	}
	
	public Detail getDetailsById(String id) {
		return personRepository.findById(id).orElseThrow(null);
	}
	
	public void createDetails(Detail details) {
		personRepository.save(details);
	}
	public void updateDetails(Detail details) {
		personRepository.save(details);
	}
	public void removeDetails(String id) {
		personRepository.deleteById(id);
	}
	public List<Detail> findByName(String name){
		return personRepository.findByusername(name);
	}
	public Page<Detail> findPaginated(int pageNo,int pageSize){
		Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
		return personRepository.findAll(pageable);
		
	}

}
