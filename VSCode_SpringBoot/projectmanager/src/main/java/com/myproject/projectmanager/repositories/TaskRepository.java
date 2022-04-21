package com.myproject.projectmanager.repositories;

import java.util.List;

import com.myproject.projectmanager.models.Task;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long>{

    List<Task> findAll();
    
}