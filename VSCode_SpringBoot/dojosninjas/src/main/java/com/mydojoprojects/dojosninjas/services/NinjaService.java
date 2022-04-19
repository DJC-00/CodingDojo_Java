package com.mydojoprojects.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mydojoprojects.dojosninjas.models.Ninja;
import com.mydojoprojects.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	// Injecting the repository
	private final NinjaRepository ninjaRepo;

	public NinjaService(NinjaRepository ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}

	// Find All Ninja From Repo
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	// Create a Ninja From Repo
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
	
	// Find One Ninja From Repo
	public Ninja findNinja(Long id) {
		
		Optional<Ninja> optNinja = ninjaRepo.findById(id);
		
		if(optNinja.isPresent()) {
			return optNinja.get();
			
		} else {
			
			return null;
		}
	}
	
	// Update a Ninja From Repo
	public Ninja updateNinja(Ninja updatedNinja) {
        Long ninjaID = updatedNinja.getId();
        System.out.println("Service File");
        System.out.println(updatedNinja.getId());
        Ninja ninjaFromDB = findNinja(ninjaID);
        if (ninjaFromDB == null){
            return null;
        }

        ninjaFromDB.setFirstName(updatedNinja.getFirstName());
        ninjaFromDB.setLastName(updatedNinja.getLastName());
        ninjaFromDB.setAge(updatedNinja.getAge());
        ninjaFromDB.setDojo(updatedNinja.getDojo());
        
		return ninjaRepo.save(ninjaFromDB);
	}
	
	// Delete A Ninja From Repo 
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
