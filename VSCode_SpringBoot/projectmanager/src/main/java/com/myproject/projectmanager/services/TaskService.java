package com.myproject.projectmanager.services;

import java.util.List;
import java.util.Optional;

import com.myproject.projectmanager.models.Task;
import com.myproject.projectmanager.repositories.TaskRepository;

import org.springframework.stereotype.Service;


@Service
public class TaskService {
	// Injecting the repository
	private final TaskRepository taskRepo;

	public TaskService(TaskRepository taskRepo) {
		this.taskRepo = taskRepo;
	}

	// Find All Task From Repo
	public List<Task> allTasks() {
		return taskRepo.findAll();
	}
	
	// Create a Task From Repo
	public Task createTask(Task task) {
		return taskRepo.save(task);
	}
	
	// Find One Task From Repo
	public Task findTask(Long id) {
		
		Optional<Task> optTask = taskRepo.findById(id);
		
		if(optTask.isPresent()) {
			return optTask.get();
			
		} else {
			
			return null;
		}
	}
	
	// Update a Task From Repo
	public Task updateTask(Task updatedTask) {
        Task taskFromDB = findTask(updatedTask.getId());
        if (taskFromDB == null){
            return null;
        }

        taskFromDB.setTaskDesc(updatedTask.getTaskDesc());
        taskFromDB.setTeam(updatedTask.getTeam());
        
		return taskRepo.save(taskFromDB);
	}
	
	// Delete A Task From Repo 
	public void deleteTask(Long id) {
		taskRepo.deleteById(id);
	}
}
