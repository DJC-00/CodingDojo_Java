package com.project.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MainCtrl {
    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        model.addAttribute("check", "okay");
        return "index.jsp";
    }

    // ...
    @RequestMapping("/login")
    public String login(
	    @RequestParam(value="email") String email,
    	@RequestParam(value="password") String password,
        Model model) {
        
        model.addAttribute("email", email);
        model.addAttribute("password", password);
    
    	// CODE TO PROCESS FORM ie. check email and password
    	
    	return "results.jsp"; // <-- we'll change this when we learn redirecting
}
// ...

}

