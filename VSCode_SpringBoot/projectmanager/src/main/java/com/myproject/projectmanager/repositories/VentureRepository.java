package com.myproject.projectmanager.repositories;

import java.util.List;

import com.myproject.projectmanager.models.Venture;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentureRepository extends CrudRepository<Venture, Long>{

    List<Venture> findAll();
    
}