package com.djc.project.ninjagold.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class MainCtrl {
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("check", "okay");
        return "index.jsp";
    }
    @RequestMapping(value="/start", method=RequestMethod.POST)
    public String start(HttpSession session ,@RequestParam(value="name") String name) {
		session.setAttribute("name", name);
        session.setAttribute("gold", 0);
        session.setAttribute("eventLog",new ArrayList<String>());
        return "redirect:/game"; 
    }
    @RequestMapping("/game")
    public String gameMain(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("name"));
        model.addAttribute("action", session.getAttribute("action"));
        model.addAttribute("gold", session.getAttribute("gold"));
        model.addAttribute("eventLog", session.getAttribute("eventLog"));
        return "ninjaGold.jsp"; 
    }
    @RequestMapping("/game/choice")
    public String gameChoice(HttpSession session , @RequestParam(value="action") String action) {
        System.out.println("test");
        session.setAttribute("action", action);
        Random rand = new Random();
        int goldVal = 0;
        String gainOrLoss;
        switch (action){
            case "Farm": 
                goldVal = rand.nextInt(10) + 10;
                gainOrLoss = "gained";
            break;
            case "Cave": 
                goldVal = rand.nextInt(5) + 5;
                gainOrLoss = "gained";
            break;
            case "House": 
                goldVal = rand.nextInt(3) + 2;
                gainOrLoss = "gained";
            break;
            case "Quest":
                goldVal = rand.nextInt(50);
                if (rand.nextDouble() < .5){
                    goldVal = goldVal * -1;
                    gainOrLoss = "lost";
                }
                else{
                    gainOrLoss = "gained";
                }
            break;
            case "Spa": 
                goldVal = -5;
                gainOrLoss = "lost";
            break;
            default: return "redirect:/game";
        }


        String sName = (String) session.getAttribute("name");
        ArrayList<Object> sLog = (ArrayList<Object>) session.getAttribute("eventLog");
        String newEvent = sName + " did the " + action + " action, and " + gainOrLoss + " " + goldVal + " gold. Time: " + new Date() + "\n";
        sLog.add(newEvent) ;
        session.setAttribute("eventLog", sLog);

        Integer totalGold = (Integer) session.getAttribute("gold");
        totalGold = totalGold + goldVal;
        session.setAttribute("gold", totalGold);

        return "redirect:/game";
    }
}