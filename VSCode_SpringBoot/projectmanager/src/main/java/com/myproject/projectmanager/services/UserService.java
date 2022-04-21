package com.myproject.projectmanager.services;

import java.util.List;
import java.util.Optional;

import com.myproject.projectmanager.models.LoginUser;
import com.myproject.projectmanager.models.User;
import com.myproject.projectmanager.repositories.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepo;
    
    public User register(User newUser, BindingResult result) {
        
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "Unique", "You cannot email with this 								email, must use dif email!");
    	}
    	
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "Your password and 								confirm password must matchy matchy!!");
        }
        
        if(result.hasErrors()) {
        	return null;
        }
        
        String hashed = BCrypt.hashpw(newUser.getPassword(), 						BCrypt.gensalt());
        newUser.setPassword(hashed);
        
        return userRepo.save(newUser);
    }
    
    public User login(LoginUser newLogin, BindingResult result) {

        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
        	result.rejectValue("email", "Unique", "We don't know who you are! Email does not exist in the Database!");
        	return null;
        }

        User user = potentialUser.get();
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
        	result.rejectValue("password", "Matches", "That password does not match the password for this email");
        	return null;
        }

        if(result.hasErrors()) {
        	return null;
        } else {
        	return user;
        }
    }

    public User findUserById(Long id) {
		
		Optional<User> optTeam = userRepo.findById(id);
		
		if(optTeam.isPresent()) {
			return optTeam.get();
			
		} else {
			
			return null;
		}
	}
}