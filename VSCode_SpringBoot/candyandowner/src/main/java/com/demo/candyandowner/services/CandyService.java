package com.demo.candyandowner.services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.candyandowner.models.Candy;
import com.demo.candyandowner.repositories.CandyRepository;

@Service
public class CandyService {

	// Injecting the repository
	private final CandyRepository candyRepo;

	
	
	public CandyService(CandyRepository candyRepo) {
		this.candyRepo = candyRepo;
	}





	// Find All Candy From Repo
	public List<Candy> allCandys() {
		return candyRepo.findAll();
	}
	
	
	// Create a Candy From Repo
	public Candy createCandy(Candy candy) {
		return candyRepo.save(candy);
	}
	
	
	// Find One Candy From Repo
	public Candy findCandy(Long id) {
		
		Optional<Candy> optCandy = candyRepo.findById(id);
		
		if(optCandy.isPresent()) {
			return optCandy.get();
			
		} else {
			
			return null;
		}
		
	}
	
	
	// Delete A Candy From Repo 
	public void candyMan(Long id) {
		candyRepo.deleteById(id);
	}
	
	
	// Update a Candy From Repo
	public Candy updateCandy(Candy candy) {
		return candyRepo.save(candy);
	}
	
}