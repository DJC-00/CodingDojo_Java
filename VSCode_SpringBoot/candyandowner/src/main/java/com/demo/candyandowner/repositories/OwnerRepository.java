package com.demo.candyandowner.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.candyandowner.models.Owner;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long>{

	
	List<Owner> findAll();
	
	
}