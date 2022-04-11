package com.djc.project.omikujiform.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainCtrl {
	@RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("check", "okay");
        return "index.jsp"; 
    }
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(
		HttpSession session,
		@RequestParam(value="num") String num,
		@RequestParam(value="city") String city, 
		@RequestParam(value="person") String person,
		@RequestParam(value="hobby") String hobby, 
		@RequestParam(value="livingThing") String livingThing,
		@RequestParam(value="niceThing") String niceThing){
			session.setAttribute("num", num);
			session.setAttribute("city", city);
			session.setAttribute("person", person);
			session.setAttribute("hobby", hobby);
			session.setAttribute("livingThing", livingThing);
			session.setAttribute("niceThing", niceThing);
		// CODE TO PROCESS FORM ie. check email and password
		return "redirect:/dashboard";
	}
	@RequestMapping(value="/dashboard", method = RequestMethod.GET)
	public String dashboard(HttpSession session, Model model) {
		model.addAttribute("num", session.getAttribute("num"));
		model.addAttribute("city", session.getAttribute("city"));
		model.addAttribute("person", session.getAttribute("person"));
		model.addAttribute("hobby", session.getAttribute("hobby"));
		model.addAttribute("livingThing", session.getAttribute("livingThing"));
		model.addAttribute("niceThing", session.getAttribute("niceThing"));
		session.invalidate();

		// CODE TO PROCESS FORM ie. check email and password
		return "dashboard.jsp";
	}
}
