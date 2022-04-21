package com.myproject.projectmanager.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.myproject.projectmanager.models.LoginUser;
import com.myproject.projectmanager.models.Task;
import com.myproject.projectmanager.models.Team;
import com.myproject.projectmanager.models.User;
import com.myproject.projectmanager.models.Venture;
import com.myproject.projectmanager.services.TaskService;
import com.myproject.projectmanager.services.TeamService;
import com.myproject.projectmanager.services.UserService;
import com.myproject.projectmanager.services.VentureService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainCtrl {
    @RequestMapping("/")
    public String indexTest(Model model) {
        model.addAttribute("check", "okay");
        return "index.jsp";
    }

	// Injecting out VentureService
	private final TeamService teamServ;
    private final VentureService ventureServ;
	private final TaskService taskServ;
	private final UserService userServ;

	public MainCtrl(TeamService teamServ, VentureService ventureServ, TaskService taskServ, UserService userServ) {
		super();
		this.teamServ = teamServ;
		this.taskServ = taskServ;
        this.ventureServ = ventureServ;
		this.userServ = userServ;
	}
	
    @GetMapping("/")
    public String index(Model model) {

        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "login.jsp";
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
            return "login.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", newUser.getId());
        return "redirect:/success";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        // User user = userServ.login(newLogin, result);
        User user = userServ.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "login.jsp";
        }

        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("user_id", user.getId());
        return "redirect:/success";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/success")
    public String success(HttpSession session, Model model) {
        Long userId = (Long) session.getAttribute("user_id");
        model.addAttribute("currentUser", userServ.findUserById(userId));
        return "success.jsp";
    }

    @GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {
		
		// Send our Candies to the JSP using Model model
        Long userId = (Long) session.getAttribute("user_id");

        
        model.addAttribute("currentUser", userServ.findUserById(userId));
		model.addAttribute("allVentures" , ventureServ.allVentures());
        model.addAttribute("allTeams" , teamServ.allTeams());
        model.addAttribute("userTeams" , teamServ.userTeams(userId));
        model.addAttribute("otherTeams" , teamServ.otherTeams(userId));
		
		return "dashboard.jsp";
	}

    @GetMapping("/newVenture")
	public String newVentureForm(@ModelAttribute("venture") Venture venture, Model model) {
        model.addAttribute("allTeams", teamServ.allTeams() );
		return "newVenture.jsp";
	}

    @GetMapping("/newTask")
	public String newVentureForm(@ModelAttribute("task") Task task, Model model) {
		return "newVenture.jsp";
	}

    @GetMapping("/oneVenture/{id}")
	public String oneVenture(@PathVariable("id") Long id,Model model) {
		
		model.addAttribute("venture", ventureServ.findVenture(id));
		
		return "oneVenture.jsp";
	}	

    @PostMapping("/processVenture")
	public String postingVenture(@Valid @ModelAttribute("venture") Venture venture, BindingResult result, Model model, HttpSession session) {
		
		if (result.hasErrors()) {
			// model.addAttribute("allDojos", dojoServ.allDojos() );
			return "newVenture.jsp";
			
		} else {
            Team newTeam = new Team();
            Long userId = (Long) session.getAttribute("user_id");
			venture.setUser(userServ.findUserById(userId));
			Venture newVenture = ventureServ.createVenture(venture);
            newTeam.setVentures(newVenture);
            newTeam.setUsers(userServ.findUserById(userId));
            teamServ.createTeam(newTeam);
			return "redirect:/dashboard";
		}
		
	}

    @GetMapping("/joinLeaveTeam/{id}")
	public String joinTeam(@PathVariable("id") Long id, HttpSession session) {
        Team newTeam = new Team();

        newTeam.setVentures(ventureServ.findVenture(id));
        newTeam.setUsers(userServ.findUserById((Long) session.getAttribute("user_id")));

        if (teamServ.teamCheck(newTeam.getUsers().getId(), newTeam.getVentures().getId())){
            teamServ.createTeam(newTeam);
        } else if (!teamServ.teamCheck(newTeam.getUsers().getId(), newTeam.getVentures().getId())){
            teamServ.leaveTeam(newTeam.getUsers().getId(), newTeam.getVentures().getId());
        }
        return "redirect:/dashboard";

		
	}

    @GetMapping("/team/delete/{id}")
    public String deleteTeam(@PathVariable("id") Long id){
        Team teamToDelete = teamServ.findTeam(id);

        ventureServ.deleteVenture(teamToDelete.getVentures().getId());
        return "redirect:/dashboard";
    }

    @GetMapping("/oneVenture/{id}/edit")
	public String updateVentureForm(@PathVariable("id") Long id, @ModelAttribute("venture") Venture venture, Model model) {
		
		model.addAttribute("venture", ventureServ.findVenture(id));
		return "updateVenture.jsp";
	}
	
	// Process the Post to update Venture
	@PutMapping(value="/oneVenture/{id}")
	public String updateVentureConfirm(@Valid @ModelAttribute("venture") Venture venture, BindingResult result, HttpSession session) {
		
		if(result.hasErrors()) {
			return "updateVenture.jsp";
			
		} else {
            venture.setUser(userServ.findUserById((Long) session.getAttribute("user_id")));
			ventureServ.updateVenture(venture);
			return "redirect:/oneVenture/{id}";
			
		}
		
	}

    // @GetMapping("/newTeam")
	// public String newVentureForm(@ModelAttribute("team") Team team, Model model) {
		
	// 	model.addAttribute("allDojos", dojoServ.allDojos() );
	// 	return "newVenture.jsp";
	// }
}