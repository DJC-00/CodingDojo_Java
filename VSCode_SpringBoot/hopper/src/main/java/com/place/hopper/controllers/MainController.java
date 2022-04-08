package com.place.hopper.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("check", "okay");
        return "index.jsp";
    }
    @RequestMapping("/p2")
    public String pTwo(Model model) {
        model.addAttribute("name", "value");
        return "pTwo.jsp";
    }
}
