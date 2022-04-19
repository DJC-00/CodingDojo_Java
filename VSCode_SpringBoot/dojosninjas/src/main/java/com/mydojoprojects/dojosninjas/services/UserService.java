package com.mydojoprojects.dojosninjas.services;

import java.util.Optional;

import com.mydojoprojects.dojosninjas.models.LoginUser;
import com.mydojoprojects.dojosninjas.models.User;
import com.mydojoprojects.dojosninjas.repositories.UserRepository;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepo;
    
    public User register(User newUser, BindingResult result) {
        
        // Reject if email is taken (present in database)
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "Unique", "You cannot email with this 								email, must use dif email!");
    	}
    	
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "Your password and 								confirm password must matchy matchy!!");
        }
        
        // Return null if result has errors
        if(result.hasErrors()) {
        	return null;
        }
        
        // Hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), 						BCrypt.gensalt());
        newUser.setPassword(hashed);
        
        return userRepo.save(newUser);
    }
    
    public User login(LoginUser newLogin, BindingResult result) {

    	// Find user in the DB by email
        // Reject if NOT present
        Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
        if(!potentialUser.isPresent()) {
        	result.rejectValue("email", "Unique", "We don't know who you are! Email does not exist in the Database!");
        	return null;
        }
        User user = potentialUser.get();
        // Reject if BCrypt password match fails
        if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
        	result.rejectValue("password", "Matches", "That password does not match the password for this email");
        	return null;
        }
        // Return null if result has errors
        if(result.hasErrors()) {
        	return null;
        } else {
        // Otherwise, return the user object
        	return user;
        }
    	
    }

}