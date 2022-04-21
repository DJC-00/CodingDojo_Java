package com.mydojoprojects.dojosninjas.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.mydojoprojects.dojosninjas.models.Dojo;
import com.mydojoprojects.dojosninjas.models.LoginUser;
import com.mydojoprojects.dojosninjas.models.Ninja;
import com.mydojoprojects.dojosninjas.models.User;
import com.mydojoprojects.dojosninjas.services.DojoService;
import com.mydojoprojects.dojosninjas.services.NinjaService;
import com.mydojoprojects.dojosninjas.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomeCtrl {
	
	// Injecting out NinjaService
	private final NinjaService ninjaServ;
	private final DojoService dojoServ;
	private final UserService userServ;
	
    // public HomeCtrl(NinjaService ninjaServ, DojoService dojoServ, UserService userServ) {
	public HomeCtrl(NinjaService ninjaServ, DojoService dojoServ, UserService userServ) {
		super();
		this.ninjaServ = ninjaServ;
		this.dojoServ = dojoServ;
		this.userServ = userServ;
	}
	
	 @GetMapping("/")
	    public String index(Model model) {
	    
	        // Bind empty User and LoginUser objects to the JSP
	        // to capture the form input
	        model.addAttribute("newUser", new User());
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	 
	 @PostMapping("/register")
	    public String register(@Valid @ModelAttribute("newUser") User newUser, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // TO-DO Later -- call a register method in the service 
	        // to do some extra validations and create a new user!
	        
		 	userServ.register(newUser, result);
		 	
	        if(result.hasErrors()) {
	            // Be sure to send in the empty LoginUser before 
	            // re-rendering the page.
	            model.addAttribute("newLogin", new LoginUser());
	            return "index.jsp";
	        }
	        
	        // No errors! 
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	        session.setAttribute("user_id", newUser.getId());
	        return "redirect:/dashboard";
	    }
	    
	    @PostMapping("/login")
	    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	            BindingResult result, Model model, HttpSession session) {
	        
	        // Add once service is implemented:
	        // User user = userServ.login(newLogin, result);
	    	User user = userServ.login(newLogin, result);
	        if(result.hasErrors()) {
	            model.addAttribute("newUser", new User());
	            return "index.jsp";
	        }
	    
	        // No errors! 
	        // TO-DO Later: Store their ID from the DB in session, 
	        // in other words, log them in.
	        session.setAttribute("user_id", user.getId());
	        return "redirect:/dashboard";
	    }
	    
	    @GetMapping("/logout")
	    public String logout(HttpSession session) {
	    	session.invalidate();
	    	return "redirect:/";
	    }
	
	
	// Route to show all candies
	// Needs: Model model
	/*****************************************************
	***************     DASHBOARD    *********************
	******************************************************
	**/
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		
		// Send our Candies to the JSP using Model model
		model.addAttribute("allNinjas" , ninjaServ.allNinjas());
		
		return "dashboard.jsp";
	}

	// Routes to Make a Ninja
	
	// Render the new Ninja Form
	@GetMapping("/newNinja")
	public String newNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		model.addAttribute("allDojos", dojoServ.allDojos() );
		return "newNinja.jsp";
	}
	// Route to Render Dojo Form
	@GetMapping("/newDojo")
	public String newDojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}
	
	// Process the Post to create Ninja
	@PostMapping("/processNinja")
	public String postingNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			model.addAttribute("allDojos", dojoServ.allDojos() );
			return "newNinja.jsp";
			
		} else {
			
			ninjaServ.createNinja(ninja);
			return "redirect:/dashboard";
		}
		
	}
	
	// Process The Post to create Dojo
	@PostMapping("/processDojo")
	public String postingDojo(@Valid @ModelAttribute("dojo") Dojo dojo, 								BindingResult result) {
		// if (result.hasErrors()) {
			// return "newDojo.jsp";
		// } else {
			dojoServ.createDojo(dojo);
			return "redirect:/dashboard";
		// }
	}
	
	// Route to show One Ninja
	@GetMapping("/oneNinja/{id}")
	public String oneNinja(@PathVariable("id") Long id,Model model) {
		
		model.addAttribute("ninja", ninjaServ.findNinja(id));
		
		return "oneNinja.jsp";
	}	
    
    @GetMapping("/oneDojo/{id}")
	public String oneDojo(@PathVariable("id") Long id,Model model) {
		
		model.addAttribute("dojo", dojoServ.findDojo(id));
        model.addAttribute("dojoNinjas", dojoServ.allDojos());
		
		return "oneDojo.jsp";
	}
	
	// Route to Delete a Ninja
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		ninjaServ.deleteNinja(id);
		
		return "redirect:/dashboard";
	}
	
	// Routes to Update a Ninja
	
	// Render the update Ninja Form
	// DONT FORGET TO ADD ID
	
	@GetMapping("/oneNinja/{id}/edit")
	public String updateNinjaForm(@PathVariable("id") Long id, @ModelAttribute("ninja") Ninja ninja, Model model) {
		
		model.addAttribute("ninja", ninjaServ.findNinja(id));
        model.addAttribute("allDojos", dojoServ.allDojos());
		return "updateNinja.jsp";
	}
	
	// Process the Post to update Ninja
	@PutMapping(value="/oneNinja/{id}")
	public String updateNinjaConfirm(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
		
		if(result.hasErrors()) {
			return "updateNinja.jsp";
			
		} else {
            System.out.println("Confirm");
			System.out.println(ninja.getDojo().getId());
			ninjaServ.updateNinja(ninja);
			return "redirect:/oneNinja/{id}";
			
		}
		
	}
	
	
	
}