package com.demo.candyandowner.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.candyandowner.models.Candy;

@Repository
public interface CandyRepository extends CrudRepository<Candy, Long>{

	
	
	List<Candy> findAll();
	
	
	
}