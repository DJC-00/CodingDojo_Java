package com.demo.candyandowner.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.candyandowner.models.Owner;
import com.demo.candyandowner.repositories.OwnerRepository;

@Service
public class OwnerService {

	private final OwnerRepository ownerRepo;

	public OwnerService(OwnerRepository ownerRepo) {
		this.ownerRepo = ownerRepo;
	}
	
	
	// Find all the Owners
	public List<Owner> allOwners() {
		return ownerRepo.findAll();
	}
	
	
	// Create an Owner
	public Owner createOwner(Owner owner) {
		return ownerRepo.save(owner);
	}
	
	
	// Find One Owner From Repo
	public Owner findOwner(Long id) {
		
		Optional<Owner> optOwner = ownerRepo.findById(id);
		
		if(optOwner.isPresent()) {
			return optOwner.get();
			
		} else {
			
			return null;
		}
		
	}
	
}