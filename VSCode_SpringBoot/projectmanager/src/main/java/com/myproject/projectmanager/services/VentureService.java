package com.myproject.projectmanager.services;

import java.util.List;
import java.util.Optional;

import com.myproject.projectmanager.models.Venture;
import com.myproject.projectmanager.repositories.VentureRepository;

import org.springframework.stereotype.Service;

@Service
public class VentureService {
    // Injecting the repository
    private final VentureRepository ventureRepo;

    public VentureService(VentureRepository ventureRepo) {
        this.ventureRepo = ventureRepo;
    }

    // Find All Venture From Repo
    public List<Venture> allVentures() {
        return ventureRepo.findAll();
    }
    
    // Create a Venture From Repo
    public Venture createVenture(Venture venture) {
        return ventureRepo.save(venture);
    }
    
    // Find One Venture From Repo
    public Venture findVenture(Long id) {
        
        Optional<Venture> optVenture = ventureRepo.findById(id);
        
        if(optVenture.isPresent()) {
            return optVenture.get();
            
        } else {
            
            return null;
        }
    }
    
    // Update a Venture From Repo
    public Venture updateVenture(Venture updatedVenture) {
        // Long ventureID = updatedVenture.getId();
        Venture ventureFromDB = findVenture(updatedVenture.getId());
        if (ventureFromDB == null){
            return null;
        }

        ventureFromDB.setTitle(updatedVenture.getTitle());
        ventureFromDB.setDescription(updatedVenture.getDescription());
        ventureFromDB.setDueDate(updatedVenture.getDueDate());
        ventureFromDB.setUser(updatedVenture.getUser());
        
        return ventureRepo.save(ventureFromDB);

        //Long id, String title, String description, Date dueDate, Date createdAt, Date updatedAt
    }
    
    // Delete A Venture From Repo 
    public void deleteVenture(Long id) {
        ventureRepo.deleteById(id);
    }
}