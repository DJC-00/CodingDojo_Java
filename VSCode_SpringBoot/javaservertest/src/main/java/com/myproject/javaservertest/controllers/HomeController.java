package com.myproject.javaservertest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    @RequestMapping("/people")
    public String people(Model model) {
        model.addAttribute("color","red");
        return "people.jsp";
    }
}
