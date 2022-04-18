package com.mydojoprojects.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mydojoprojects.dojosninjas.models.Dojo;
import com.mydojoprojects.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepo;

	public DojoService(DojoRepository dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
	
	// Find all the Dojos
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	
	// Create a Dojo
	public Dojo createDojo(Dojo dojo) {
        System.out.println("Createing Dojo");
		return dojoRepo.save(dojo);
	}
	
	
	// Find One Dojo From Repo
	public Dojo findDojo(Long id) {
		
		Optional<Dojo> optDojo = dojoRepo.findById(id);
		
		if(optDojo.isPresent()) {
			return optDojo.get();
			
		} else {
			
			return null;
		}
		
	}
	
}