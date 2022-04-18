package com.mydojoprojects.dojosninjas.repositories;

import java.util.List;

import com.mydojoprojects.dojosninjas.models.Dojo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long>{

    List<Dojo> findAll();
    
}