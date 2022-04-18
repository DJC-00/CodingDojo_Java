package com.mydojoprojects.dojosninjas.repositories;

import java.util.List;

import com.mydojoprojects.dojosninjas.models.Ninja;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{

    List<Ninja> findAll();
    
}