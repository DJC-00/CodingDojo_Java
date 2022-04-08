package com.projects.counterproj.counter.controllers;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
@Controller
public class CounterCtrl {

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        if (session.getAttribute("viewCount") == null){
            session.setAttribute("viewCount", 0);
        }
        Integer views = (Integer) session.getAttribute("viewCount");
        views++;
        session.setAttribute("viewCount", views);
        model.addAttribute("check", "okay");
        return "index.jsp";
    }
}


