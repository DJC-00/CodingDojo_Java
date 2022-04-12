package com.person.project.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
public class MainCtrl {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("check", "okay");
        return "index.jsp";
    }
}
